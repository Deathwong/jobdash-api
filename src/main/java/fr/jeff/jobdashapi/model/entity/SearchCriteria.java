package fr.jeff.jobdashapi.model.entity;

import fr.jeff.jobdashapi.model.enums.ContractType;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "search_criteria")
public class SearchCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "entitled_position", nullable = false)
    private String entitledPosition;

    @Column(name = "location", nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", nullable = false)
    private ContractType contractType;

    @Column(name = "last_execution")
    private Instant lastExecution;
}
