package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.SchoolResponse;
import fr.jeff.jobdashapi.model.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolResponse toResponse(School school);
}
