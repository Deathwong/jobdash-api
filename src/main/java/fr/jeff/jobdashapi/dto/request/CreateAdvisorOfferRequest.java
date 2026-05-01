package fr.jeff.jobdashapi.dto.request;

import fr.jeff.jobdashapi.model.enums.ContractType;

import java.util.List;
import java.util.UUID;

public record CreateAdvisorOfferRequest(
        String title,
        String company,
        ContractType contractType,
        String location,
        String url,
        String description,
        List<UUID> classRoomIds
) {}
