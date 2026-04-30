package fr.jeff.jobdashapi.model.entity;

import fr.jeff.jobdashapi.model.enums.ContractType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "advisor_offers")
public class AdvisorOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private SchoolUser advisor;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "company", nullable = false)
    private String company;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", nullable = false)
    private ContractType contractType;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "url")
    private String url;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "advisor_offer_class_rooms",
            joinColumns = @JoinColumn(name = "advisor_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "class_room_id")
    )
    private List<ClassRoom> classRooms;

    @OneToMany(mappedBy = "advisorOffer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdvisorOfferDocument> documents;
}
