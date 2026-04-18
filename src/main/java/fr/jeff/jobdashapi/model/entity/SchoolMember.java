package fr.jeff.jobdashapi.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "school_members")
public class SchoolMember {

    @Id
    @Column(name = "user_id", nullable = false)
    private UUID id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;
}
