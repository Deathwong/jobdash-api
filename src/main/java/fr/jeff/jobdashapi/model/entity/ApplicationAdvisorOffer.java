package fr.jeff.jobdashapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "application_advisor_offers")
public class ApplicationAdvisorOffer {

    @Id
    @Column(name = "application_id")
    private UUID id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_offer_id", nullable = false)
    private AdvisorOffer advisorOffer;
}
