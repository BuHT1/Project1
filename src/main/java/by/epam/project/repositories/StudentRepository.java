package by.epam.project.repositories;

import by.epam.project.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    StudentEntity findByName(String lastName);
}
