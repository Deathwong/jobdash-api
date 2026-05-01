package fr.jeff.jobdashapi.dto.request;

public record ContactRequest(
        String name,
        String position,
        String email,
        String linkedin,
        Boolean isInterlocutorConvention
) {}
