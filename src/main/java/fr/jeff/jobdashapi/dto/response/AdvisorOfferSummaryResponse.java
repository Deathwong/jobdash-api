package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.ContractType;

import java.time.Instant;
import java.util.UUID;

public record AdvisorOfferSummaryResponse(
        UUID id,
        String title,
        String company,
        ContractType contractType,
        String location,
        Instant createdAt
) {}
