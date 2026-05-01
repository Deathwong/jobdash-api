package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.ClassRoom;
import fr.jeff.jobdashapi.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findByClassRoom(ClassRoom classRoom);
}
