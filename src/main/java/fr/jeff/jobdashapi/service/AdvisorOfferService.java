package fr.jeff.jobdashapi.service;

import fr.jeff.jobdashapi.dto.request.CreateAdvisorOfferRequest;
import fr.jeff.jobdashapi.dto.response.AdvisorOfferDetailResponse;
import fr.jeff.jobdashapi.dto.response.AdvisorOfferSummaryResponse;
import fr.jeff.jobdashapi.mapper.AdvisorOfferMapper;
import fr.jeff.jobdashapi.model.entity.AdvisorOffer;
import fr.jeff.jobdashapi.model.entity.ClassRoom;
import fr.jeff.jobdashapi.model.entity.SchoolUser;
import fr.jeff.jobdashapi.repository.AdvisorOfferRepository;
import fr.jeff.jobdashapi.repository.ClassRoomRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdvisorOfferService {

    private final AdvisorOfferRepository advisorOfferRepository;
    private final ClassRoomRepository classRoomRepository;
    private final AdvisorOfferMapper advisorOfferMapper;

    public List<AdvisorOfferSummaryResponse> getAdvisorOffers(SchoolUser advisor) {
        return advisorOfferRepository.findByAdvisor(advisor).stream()
                .map(advisorOfferMapper::toSummaryResponse)
                .toList();
    }

    public AdvisorOfferDetailResponse getOffer(UUID id) {
        return advisorOfferMapper.toDetailResponse(findById(id));
    }

    public AdvisorOfferDetailResponse create(CreateAdvisorOfferRequest request, SchoolUser advisor) {
        List<ClassRoom> classRooms = classRoomRepository.findAllById(request.classRoomIds());

        AdvisorOffer offer = AdvisorOffer.builder()
                .advisor(advisor)
                .title(request.title())
                .company(request.company())
                .contractType(request.contractType())
                .location(request.location())
                .url(request.url())
                .description(request.description())
                .classRooms(classRooms)
                .build();
        return advisorOfferMapper.toDetailResponse(advisorOfferRepository.save(offer));
    }

    public AdvisorOfferDetailResponse update(UUID id, CreateAdvisorOfferRequest request, SchoolUser advisor) {
        AdvisorOffer offer = findByIdAndAdvisor(id, advisor);
        List<ClassRoom> classRooms = classRoomRepository.findAllById(request.classRoomIds());

        offer.setTitle(request.title());
        offer.setCompany(request.company());
        offer.setContractType(request.contractType());
        offer.setLocation(request.location());
        offer.setUrl(request.url());
        offer.setDescription(request.description());
        offer.setClassRooms(classRooms);
        return advisorOfferMapper.toDetailResponse(advisorOfferRepository.save(offer));
    }

    public void delete(UUID id, SchoolUser advisor) {
        AdvisorOffer offer = findByIdAndAdvisor(id, advisor);
        advisorOfferRepository.delete(offer);
    }

    private AdvisorOffer findById(UUID id) {
        return advisorOfferRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AdvisorOffer not found: " + id));
    }

    private AdvisorOffer findByIdAndAdvisor(UUID id, SchoolUser advisor) {
        return advisorOfferRepository.findById(id)
                .filter(o -> o.getAdvisor().getId().equals(advisor.getId()))
                .orElseThrow(() -> new EntityNotFoundException("AdvisorOffer not found: " + id));
    }
}
