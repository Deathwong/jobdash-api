package fr.jeff.jobdashapi.dto.request;

import fr.jeff.jobdashapi.model.enums.Role;

import java.util.UUID;

public record CreateSchoolUserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role,
        UUID schoolId
) {}
