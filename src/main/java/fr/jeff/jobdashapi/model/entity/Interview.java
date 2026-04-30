package fr.jeff.jobdashapi.model.entity;

import fr.jeff.jobdashapi.model.enums.InterviewType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private InterviewType type;

    @Column(name = "interview_date", nullable = false)
    private Instant interviewDate;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
}
