package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.ContractType;

import java.time.Instant;
import java.util.UUID;

public record SearchCriteriaResponse(
        UUID id,
        String entitledPosition,
        String location,
        ContractType contractType,
        Instant lastExecution
) {}
