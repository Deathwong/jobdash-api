package fr.jeff.jobdashapi.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "user_id")
    private UUID id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassRoom classRoom;
}
