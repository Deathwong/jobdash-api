package fr.jeff.jobdashapi.dto.request;

import fr.jeff.jobdashapi.model.enums.ApplicationStatus;
import fr.jeff.jobdashapi.model.enums.ContractType;
import fr.jeff.jobdashapi.model.enums.PostulationCanal;

public record UpdateApplicationRequest(
        String title,
        String company,
        String location,
        String url,
        ContractType contractType,
        PostulationCanal postulationCanal,
        String notes,
        ApplicationStatus status
) {}
