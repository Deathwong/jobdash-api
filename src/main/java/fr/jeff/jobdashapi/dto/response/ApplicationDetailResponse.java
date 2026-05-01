package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.ApplicationStatus;
import fr.jeff.jobdashapi.model.enums.ContractType;
import fr.jeff.jobdashapi.model.enums.PostulationCanal;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record ApplicationDetailResponse(
        UUID id,
        String title,
        String company,
        String location,
        String url,
        ContractType contractType,
        ApplicationStatus status,
        PostulationCanal postulationCanal,
        String notes,
        Instant updatedAt,
        List<ContactResponse> contacts,
        List<InterviewResponse> interviews,
        List<DocumentResponse> documents
) {}
