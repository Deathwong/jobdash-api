package fr.jeff.jobdashapi.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "email")
    private String email;

    @Column(name = "is_interlocutor_convention", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isInterlocutorConvention = false;
}
