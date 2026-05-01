package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.ApplicationStatus;
import fr.jeff.jobdashapi.model.enums.ContractType;

import java.time.Instant;
import java.util.UUID;

public record ApplicationSummaryResponse(
        UUID id,
        String title,
        String company,
        String location,
        ApplicationStatus status,
        ContractType contractType,
        Instant updatedAt
) {}
