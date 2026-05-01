package fr.jeff.jobdashapi.dto.request;

import java.util.UUID;

public record CreateStudentRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        UUID classRoomId
) {}
