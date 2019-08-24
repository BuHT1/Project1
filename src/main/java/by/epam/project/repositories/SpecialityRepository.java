package by.epam.project.repositories;

import by.epam.project.entities.SpecialityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<SpecialityEntity,Long> {
}
