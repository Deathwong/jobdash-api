package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.ClassRoom;
import fr.jeff.jobdashapi.model.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, UUID> {

    List<ClassRoom> findBySchool(School school);
}
