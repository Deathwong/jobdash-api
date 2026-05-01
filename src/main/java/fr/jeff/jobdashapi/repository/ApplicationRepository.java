package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {

    List<Application> findByStudent(Student student);
}
