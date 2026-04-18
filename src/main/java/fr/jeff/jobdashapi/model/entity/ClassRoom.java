package fr.jeff.jobdashapi.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "class_room")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @Column(name = "year", nullable = false)
    private String year;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "classRooms")
    private List<AdvisorOffer> advisorOffers;
}
