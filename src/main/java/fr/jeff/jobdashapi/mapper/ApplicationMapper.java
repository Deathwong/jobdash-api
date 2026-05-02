package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.ApplicationDetailResponse;
import fr.jeff.jobdashapi.dto.response.ApplicationSummaryResponse;
import fr.jeff.jobdashapi.model.entity.Application;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ContactMapper.class, InterviewMapper.class, DocumentMapper.class})
public interface ApplicationMapper {
    ApplicationSummaryResponse toSummaryResponse(Application application);
    ApplicationDetailResponse toDetailResponse(Application application);
}
