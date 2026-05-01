package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    List<Contact> findByApplication(Application application);
}
