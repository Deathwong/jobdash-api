package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.SearchCriteria;
import fr.jeff.jobdashapi.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SearchCriteriaRepository extends JpaRepository<SearchCriteria, UUID> {

    List<SearchCriteria> findByStudent(Student student);
}
