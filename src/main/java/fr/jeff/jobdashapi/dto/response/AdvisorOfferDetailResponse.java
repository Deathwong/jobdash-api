package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.ContractType;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record AdvisorOfferDetailResponse(
        UUID id,
        String title,
        String company,
        ContractType contractType,
        String location,
        String url,
        String description,
        Instant createdAt,
        SchoolUserResponse advisor,
        List<ClassRoomResponse> classRooms,
        List<DocumentResponse> documents
) {}
