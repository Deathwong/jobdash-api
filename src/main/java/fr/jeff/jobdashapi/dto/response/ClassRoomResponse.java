package fr.jeff.jobdashapi.dto.response;

import java.util.UUID;

public record ClassRoomResponse(
        UUID id,
        String name,
        String year,
        SchoolResponse school
) {}
