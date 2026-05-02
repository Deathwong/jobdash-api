package fr.jeff.jobdashapi.mapper;

import fr.jeff.jobdashapi.dto.response.AdvisorOfferDetailResponse;
import fr.jeff.jobdashapi.dto.response.AdvisorOfferSummaryResponse;
import fr.jeff.jobdashapi.model.entity.AdvisorOffer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SchoolUserMapper.class, ClassRoomMapper.class, DocumentMapper.class})
public interface AdvisorOfferMapper {
    AdvisorOfferSummaryResponse toSummaryResponse(AdvisorOffer offer);
    AdvisorOfferDetailResponse toDetailResponse(AdvisorOffer offer);
}
