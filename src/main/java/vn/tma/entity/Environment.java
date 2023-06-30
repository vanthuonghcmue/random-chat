package vn.tma.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "environments")
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "app_id", referencedColumnName = "id", nullable = false)
    private App app;

    @Column(name = "key", nullable = false, unique = true)
    private String key;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ... các getter và setter

}
