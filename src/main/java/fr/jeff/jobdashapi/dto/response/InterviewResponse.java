package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.InterviewType;

import java.time.Instant;
import java.util.UUID;

public record InterviewResponse(
        UUID id,
        InterviewType type,
        Instant interviewDate,
        String notes
) {}
