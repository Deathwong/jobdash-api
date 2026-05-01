package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.School;
import fr.jeff.jobdashapi.model.entity.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SchoolUserRepository extends JpaRepository<SchoolUser, UUID> {

    List<SchoolUser> findBySchool(School school);
}
