package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.StudentResponse;
import fr.jeff.jobdashapi.model.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ClassRoomMapper.class)
public interface StudentMapper {
    StudentResponse toResponse(Student student);
}
