package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.SchoolUserResponse;
import fr.jeff.jobdashapi.model.entity.SchoolUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SchoolMapper.class)
public interface SchoolUserMapper {
    SchoolUserResponse toResponse(SchoolUser schoolUser);
}
