package com.deaprj.spring_web_application.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "events")
public class Events {

    //--- Getters & Setters ---
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Unique human-readable code (EVT-2026-001)
    @Setter
    @Column(name = "event_code", nullable = false, unique = true, length = 50)
    private String eventCode;

    @Setter
    @Column(name = "event_name", nullable = false, length = 150)
    private String eventName;

    // Event duration
    @Setter
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Setter
    @Column(name = "end_date")
    private LocalDate endDate;

    // Venue or platform
    @Setter
    @Column(name = "venue", nullable = false, length = 200)
    private String venue;

    // Project Chair (linked to User table)
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_chair_id", nullable = false)
    private User projectChair;

    // Event status
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EventStatus status;

    // Auditing
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Column(name = "last_updated")
    private LocalDate lastUpdated;

    //--- Constructors ---
    public Events() {}

    // --- Lifecycle hooks ---
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        this.lastUpdated = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdated = LocalDate.now();
    }

}
