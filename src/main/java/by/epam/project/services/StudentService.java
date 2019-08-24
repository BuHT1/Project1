package by.epam.project.services;

import by.epam.project.entities.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    List<StudentEntity> findStudentsByMinScoreUniversityFacultySpecialityOtdelenie(String universityName, String facultyName, String specialityName, String otdelenieName, String groupName, Double minScore);
}
