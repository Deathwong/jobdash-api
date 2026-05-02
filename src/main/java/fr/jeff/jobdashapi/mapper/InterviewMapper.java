package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.InterviewResponse;
import fr.jeff.jobdashapi.model.entity.Interview;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InterviewMapper {
    InterviewResponse toResponse(Interview interview);
}
