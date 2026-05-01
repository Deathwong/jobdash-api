package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.ApplicationDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationDocumentRepository extends JpaRepository<ApplicationDocument, UUID> {

    List<ApplicationDocument> findByApplication(Application application);
}
