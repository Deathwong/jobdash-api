package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.AdvisorOffer;
import fr.jeff.jobdashapi.model.entity.AdvisorOfferDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AdvisorOfferDocumentRepository extends JpaRepository<AdvisorOfferDocument, UUID> {

    List<AdvisorOfferDocument> findByAdvisorOffer(AdvisorOffer advisorOffer);
}
