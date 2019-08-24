package by.epam.project.services.impl;

import by.epam.project.entities.StudentEntity;
import by.epam.project.services.StudentService;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    HibernateTransactionManager transactionManager;

    @Override
    public List<StudentEntity> findStudentsByMinScoreUniversityFacultySpecialityOtdelenie(String universityName, String facultyName, String specialityName, String otdelenieName, String groupName, Double minScore) {
        String hql="select s from StudentEntity s " +
                "join s.groupsEntities as groupss " +
                "join groupss.specialityOtdelenieEntity as specialityOtdelenie " +
                "join specialityOtdelenie.otdelenie as otdelenie " +
                "join specialityOtdelenie.speciality as speciality " +
                "join speciality.faculty as faculty " +
                "join faculty.university as university " +
                "where s.score>=:min_score " +
                "and groupss.name=:group_name " +
                "and otdelenie.name=:otdelenie_name " +
                "and speciality.name=:speciality_name " +
                "and faculty.name=:faculty_name " +
                "and university.name=:university_name " +
                "ORDER BY s.score DESC ";
        Query query=transactionManager.getSessionFactory().openSession().createQuery(hql,StudentEntity.class);
        query.setParameter("group_name",groupName);
        query.setParameter("otdelenie_name",otdelenieName);
        query.setParameter("speciality_name",specialityName);
        query.setParameter("faculty_name",facultyName);
        query.setParameter("university_name",universityName);
        query.setParameter("min_score",minScore);
        return query.getResultList();
    }
}
