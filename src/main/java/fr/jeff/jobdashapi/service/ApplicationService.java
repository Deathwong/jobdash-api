package fr.jeff.jobdashapi.service;

import fr.jeff.jobdashapi.dto.request.CreateApplicationRequest;
import fr.jeff.jobdashapi.dto.request.UpdateApplicationRequest;
import fr.jeff.jobdashapi.dto.response.ApplicationDetailResponse;
import fr.jeff.jobdashapi.dto.response.ApplicationSummaryResponse;
import fr.jeff.jobdashapi.mapper.ApplicationMapper;
import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.Student;
import fr.jeff.jobdashapi.model.enums.ApplicationStatus;
import fr.jeff.jobdashapi.repository.ApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    public List<ApplicationSummaryResponse> getStudentApplications(Student student) {
        return applicationRepository.findByStudent(student).stream()
                .map(applicationMapper::toSummaryResponse)
                .toList();
    }

    public ApplicationDetailResponse getApplication(UUID id, Student student) {
        Application application = findByIdAndStudent(id, student);
        return applicationMapper.toDetailResponse(application);
    }

    public ApplicationDetailResponse create(CreateApplicationRequest request, Student student) {
        Application application = Application.builder()
                .student(student)
                .title(request.title())
                .company(request.company())
                .location(request.location())
                .url(request.url())
                .contractType(request.contractType())
                .postulationCanal(request.postulationCanal())
                .notes(request.notes())
                .status(ApplicationStatus.A_CLASSER)
                .build();
        return applicationMapper.toDetailResponse(applicationRepository.save(application));
    }

    public ApplicationDetailResponse update(UUID id, UpdateApplicationRequest request, Student student) {
        Application application = findByIdAndStudent(id, student);
        application.setTitle(request.title());
        application.setCompany(request.company());
        application.setLocation(request.location());
        application.setUrl(request.url());
        application.setContractType(request.contractType());
        application.setPostulationCanal(request.postulationCanal());
        application.setNotes(request.notes());
        application.setStatus(request.status());
        return applicationMapper.toDetailResponse(applicationRepository.save(application));
    }

    public void delete(UUID id, Student student) {
        Application application = findByIdAndStudent(id, student);
        applicationRepository.delete(application);
    }

    private Application findByIdAndStudent(UUID id, Student student) {
        return applicationRepository.findById(id)
                .filter(a -> a.getStudent().getId().equals(student.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Application not found: " + id));
    }
}
