package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.ClassRoomResponse;
import fr.jeff.jobdashapi.model.entity.ClassRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SchoolMapper.class)
public interface ClassRoomMapper {
    ClassRoomResponse toResponse(ClassRoom classRoom);
}
