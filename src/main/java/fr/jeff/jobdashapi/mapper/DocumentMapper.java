package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.DocumentResponse;
import fr.jeff.jobdashapi.model.entity.AdvisorOfferDocument;
import fr.jeff.jobdashapi.model.entity.ApplicationDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentResponse toResponse(ApplicationDocument document);
    DocumentResponse toResponse(AdvisorOfferDocument document);
}
