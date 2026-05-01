package fr.jeff.jobdashapi.dto.request;

public record LoginRequest(
        String email,
        String password
) {}
