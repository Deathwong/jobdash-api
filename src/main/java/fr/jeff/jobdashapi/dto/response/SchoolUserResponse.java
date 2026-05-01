package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.Role;

import java.time.Instant;
import java.util.UUID;

public record SchoolUserResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Role role,
        Instant createdAt,
        SchoolResponse school
) {}
