package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InterviewRepository extends JpaRepository<Interview, UUID> {

    List<Interview> findByApplication(Application application);
}
