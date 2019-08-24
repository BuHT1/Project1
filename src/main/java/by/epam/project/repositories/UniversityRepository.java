package by.epam.project.repositories;

import by.epam.project.entities.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<UniversityEntity,Long>{

}
