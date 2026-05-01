package fr.jeff.jobdashapi.dto.response;

import java.util.UUID;

public record ContactResponse(
        UUID id,
        String name,
        String position,
        String email,
        String linkedin,
        Boolean isInterlocutorConvention
) {}
