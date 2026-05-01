package fr.jeff.jobdashapi.repository;

import fr.jeff.jobdashapi.model.entity.AdvisorOffer;
import fr.jeff.jobdashapi.model.entity.ClassRoom;
import fr.jeff.jobdashapi.model.entity.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AdvisorOfferRepository extends JpaRepository<AdvisorOffer, UUID> {

    List<AdvisorOffer> findByAdvisor(SchoolUser advisor);

    List<AdvisorOffer> findByClassRoomsContaining(ClassRoom classRoom);
}
