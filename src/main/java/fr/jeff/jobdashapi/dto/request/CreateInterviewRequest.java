package fr.jeff.jobdashapi.dto.request;

import fr.jeff.jobdashapi.model.enums.InterviewType;

import java.time.Instant;

public record CreateInterviewRequest(
        InterviewType type,
        Instant interviewDate,
        String notes
) {}
