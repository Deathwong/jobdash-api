package fr.jeff.jobdashapi.dto.request;

import fr.jeff.jobdashapi.model.enums.ContractType;

public record SearchCriteriaRequest(
        String entitledPosition,
        String location,
        ContractType contractType
) {}
