package by.epam.project.services;

import by.epam.project.entities.FacultyEntity;
import by.epam.project.entities.GroupEntity;
import by.epam.project.entities.OtdelenieEntity;
import by.epam.project.entities.SpecialityEntity;
import by.epam.project.entities.SpecialityOtdelenieEntity;
import by.epam.project.entities.StudentEntity;
import by.epam.project.entities.UniversityEntity;
import by.epam.project.repositories.FacultyRepository;
import by.epam.project.repositories.GroupRepository;
import by.epam.project.repositories.OtdelenieRepository;
import by.epam.project.repositories.SpecialityOtdelenieRepository;
import by.epam.project.repositories.SpecialityRepository;
import by.epam.project.repositories.StudentRepository;
import by.epam.project.repositories.UniversityRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    private static final String UNIVERSITY_NAME = "PSU";
    private static final String FACULTY_NAME = "FIT";
    private static final String GROUP_NAME = "15VS";
    private static final String SPECIALITY_NAME = "VSIS";
    private static final String FIRST_OTDELENIE_NAME = "ochnoe";
    private static final String SECOND_OTDELENIE_NAME = "zaochnoe";

    @Autowired
    StudentService service;

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    OtdelenieRepository otdelenieRepository;

    @Autowired
    SpecialityOtdelenieRepository specialityOtdelenieRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    StudentRepository studentRepository;

    @Before
    public void setUp() {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setName(UNIVERSITY_NAME);
        universityRepository.save(universityEntity);

        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setUniversity(universityEntity);
        facultyEntity.setName(FACULTY_NAME);
        facultyRepository.save(facultyEntity);

        SpecialityEntity specialityEntity = new SpecialityEntity();
        specialityEntity.setName(SPECIALITY_NAME);
        specialityEntity.setFaculty(facultyEntity);
        specialityRepository.save(specialityEntity);

        OtdelenieEntity otdelenieEntity1 = new OtdelenieEntity();
        OtdelenieEntity otdelenieEntity2 = new OtdelenieEntity();
        otdelenieEntity1.setName(FIRST_OTDELENIE_NAME);
        otdelenieEntity2.setName(SECOND_OTDELENIE_NAME);
        otdelenieRepository.save(otdelenieEntity1);
        otdelenieRepository.save(otdelenieEntity2);

        SpecialityOtdelenieEntity specialityOtdelenieEntity1 = new SpecialityOtdelenieEntity();
        SpecialityOtdelenieEntity specialityOtdelenieEntity2 = new SpecialityOtdelenieEntity();
        specialityOtdelenieEntity1.setSpeciality(specialityEntity);
        specialityOtdelenieEntity2.setSpeciality(specialityEntity);
        specialityOtdelenieEntity1.setOtdelenie(otdelenieEntity1);
        specialityOtdelenieEntity2.setOtdelenie(otdelenieEntity2);
        specialityOtdelenieRepository.save(specialityOtdelenieEntity1);
        specialityOtdelenieRepository.save(specialityOtdelenieEntity2);

        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setName(GROUP_NAME);
        groupEntity.setSpecialityOtdelenieEntity(specialityOtdelenieEntity1);
        groupEntity.setStudentsEntities(Arrays.asList(
                createStudent("Vasya Pupkin", 8.1),
                createStudent("Gena Genin", 4.1),
                createStudent("Kol Lokin", 9.0),
                createStudent("Albert Alikov", 6.5)
        ));
        groupRepository.save(groupEntity);
    }

    @After
    public void deleteAll() {
    studentRepository.deleteAllInBatch();
    groupRepository.deleteAllInBatch();
    specialityOtdelenieRepository.deleteAllInBatch();
    otdelenieRepository.deleteAllInBatch();
    specialityRepository.deleteAllInBatch();
    facultyRepository.deleteAllInBatch();
    universityRepository.deleteAllInBatch();
    }

    @Test
    public void findStudentsByMinScoreUniversityFacultySpecialityOtdelenieTest() {
        //Given
        Double minScore = 7.0;
        List<StudentEntity> expectedStudentEntities = Arrays.asList(
                studentRepository.findByName("Kol Lokin"),
                studentRepository.findByName("Vasya Pupkin"));

        //When
        List<StudentEntity> entityList = service.findStudentsByMinScoreUniversityFacultySpecialityOtdelenie(UNIVERSITY_NAME,
                FACULTY_NAME, SPECIALITY_NAME, FIRST_OTDELENIE_NAME, GROUP_NAME, minScore);

        //Then
        assertThat(entityList)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(expectedStudentEntities);
    }

    private StudentEntity createStudent(String name, double score) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setScore(score);
        return studentEntity;
    }
}