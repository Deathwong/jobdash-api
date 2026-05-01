package fr.jeff.jobdashapi.dto.response;

import java.time.Instant;
import java.util.UUID;

public record DocumentResponse(
        UUID id,
        String fileName,
        Instant uploadedAt
) {}
