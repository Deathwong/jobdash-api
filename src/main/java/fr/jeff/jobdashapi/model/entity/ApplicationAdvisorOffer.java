package fr.jeff.jobdashapi.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "application_advisor_offer")
public class ApplicationAdvisorOffer {

    @Id
    @Column(name = "application_id")
    private UUID id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_offer_id", nullable = false)
    private AdvisorOffer advisorOffer;
}
