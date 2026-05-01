package fr.jeff.jobdashapi.dto.response;

import java.util.UUID;

public record SchoolResponse(
        UUID id,
        String name,
        String emailContact
) {}
