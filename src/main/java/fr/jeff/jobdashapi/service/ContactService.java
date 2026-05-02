package fr.jeff.jobdashapi.service;

import fr.jeff.jobdashapi.dto.request.ContactRequest;
import fr.jeff.jobdashapi.dto.response.ContactResponse;
import fr.jeff.jobdashapi.mapper.ContactMapper;
import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.Contact;
import fr.jeff.jobdashapi.model.entity.Student;
import fr.jeff.jobdashapi.repository.ApplicationRepository;
import fr.jeff.jobdashapi.repository.ContactRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ApplicationRepository applicationRepository;
    private final ContactMapper contactMapper;

    public ContactResponse addContact(UUID applicationId, ContactRequest request, Student student) {
        Application application = findApplicationByIdAndStudent(applicationId, student);
        Contact contact = Contact.builder()
                .application(application)
                .name(request.name())
                .position(request.position())
                .email(request.email())
                .linkedin(request.linkedin())
                .isInterlocutorConvention(request.isInterlocutorConvention() != null ? request.isInterlocutorConvention() : false)
                .build();
        return contactMapper.toResponse(contactRepository.save(contact));
    }

    public ContactResponse updateContact(UUID contactId, ContactRequest request, Student student) {
        Contact contact = findContactByIdAndStudent(contactId, student);
        contact.setName(request.name());
        contact.setPosition(request.position());
        contact.setEmail(request.email());
        contact.setLinkedin(request.linkedin());
        if (request.isInterlocutorConvention() != null) {
            contact.setIsInterlocutorConvention(request.isInterlocutorConvention());
        }
        return contactMapper.toResponse(contactRepository.save(contact));
    }

    public void deleteContact(UUID contactId, Student student) {
        Contact contact = findContactByIdAndStudent(contactId, student);
        contactRepository.delete(contact);
    }

    private Application findApplicationByIdAndStudent(UUID applicationId, Student student) {
        return applicationRepository.findById(applicationId)
                .filter(a -> a.getStudent().getId().equals(student.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Application not found: " + applicationId));
    }

    private Contact findContactByIdAndStudent(UUID contactId, Student student) {
        return contactRepository.findById(contactId)
                .filter(c -> c.getApplication().getStudent().getId().equals(student.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Contact not found: " + contactId));
    }
}
