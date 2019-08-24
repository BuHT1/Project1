package by.epam.project.repositories;

import by.epam.project.entities.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<FacultyEntity,Long> {
}
