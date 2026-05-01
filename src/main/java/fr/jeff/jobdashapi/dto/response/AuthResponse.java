package fr.jeff.jobdashapi.dto.response;

import fr.jeff.jobdashapi.model.enums.Role;

import java.util.UUID;

public record AuthResponse(
        String token,
        UUID id,
        String email,
        String firstName,
        String lastName,
        Role role
) {}
