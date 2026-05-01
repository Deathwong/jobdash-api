package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.AdvisorOffer;
import fr.jeff.jobdashapi.model.entity.Application;
import fr.jeff.jobdashapi.model.entity.ApplicationAdvisorOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApplicationAdvisorOfferRepository extends JpaRepository<ApplicationAdvisorOffer, UUID> {

    Optional<ApplicationAdvisorOffer> findByApplication(Application application);

    List<ApplicationAdvisorOffer> findByAdvisorOffer(AdvisorOffer advisorOffer);
}
