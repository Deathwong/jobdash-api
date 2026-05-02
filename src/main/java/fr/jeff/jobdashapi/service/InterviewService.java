package fr.jeff.jobdashapi.service;

import fr.jeff.jobdashapi.dto.request.CreateInterviewRequest;
import fr.jeff.jobdashapi.dto.response.InterviewResponse;
import fr.jeff.jobdashapi.mapper.InterviewMapper;
import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.Interview;
import fr.jeff.jobdashapi.model.entity.Student;
import fr.jeff.jobdashapi.repository.ApplicationRepository;
import fr.jeff.jobdashapi.repository.InterviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final ApplicationRepository applicationRepository;
    private final InterviewMapper interviewMapper;

    public InterviewResponse addInterview(UUID applicationId, CreateInterviewRequest request, Student student) {
        Application application = findApplicationByIdAndStudent(applicationId, student);
        Interview interview = Interview.builder()
                .application(application)
                .type(request.type())
                .interviewDate(request.interviewDate())
                .notes(request.notes())
                .build();
        return interviewMapper.toResponse(interviewRepository.save(interview));
    }

    public InterviewResponse updateInterview(UUID interviewId, CreateInterviewRequest request, Student student) {
        Interview interview = findInterviewByIdAndStudent(interviewId, student);
        interview.setType(request.type());
        interview.setInterviewDate(request.interviewDate());
        interview.setNotes(request.notes());
        return interviewMapper.toResponse(interviewRepository.save(interview));
    }

    public void deleteInterview(UUID interviewId, Student student) {
        Interview interview = findInterviewByIdAndStudent(interviewId, student);
        interviewRepository.delete(interview);
    }

    private Application findApplicationByIdAndStudent(UUID applicationId, Student student) {
        return applicationRepository.findById(applicationId)
                .filter(a -> a.getStudent().getId().equals(student.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Application not found: " + applicationId));
    }

    private Interview findInterviewByIdAndStudent(UUID interviewId, Student student) {
        return interviewRepository.findById(interviewId)
                .filter(i -> i.getApplication().getStudent().getId().equals(student.getId()))
                .orElseThrow(() -> new EntityNotFoundException("Interview not found: " + interviewId));
    }
}
