package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchoolRepository extends JpaRepository<School, UUID> {
}
