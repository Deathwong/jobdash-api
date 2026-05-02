package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.ContactResponse;
import fr.jeff.jobdashapi.model.entity.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactResponse toResponse(Contact contact);
}
