package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.SearchCriteriaResponse;
import fr.jeff.jobdashapi.model.entity.SearchCriteria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchCriteriaMapper {
    SearchCriteriaResponse toResponse(SearchCriteria searchCriteria);
}
