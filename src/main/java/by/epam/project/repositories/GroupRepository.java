package by.epam.project.repositories;

import by.epam.project.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity,Long> {
}
