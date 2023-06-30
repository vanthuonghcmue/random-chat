package vn.tma.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "behaviors")
public class Behavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "env_id", referencedColumnName = "id", nullable = false)
    private Environment environment;

    @Column(name = "version_operator", nullable = false)
    private String versionOperator;

    @Column(name = "version_number", nullable = false)
    private String versionNumber;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "time_operator")
    private String timeOperator;

    @Column(name = "numerical_order", nullable = false)
    private Integer numericalOrder;

    @Column(name = "language")
    private String language;

    @Column(name = "data", nullable = false)
    private String data;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // ... các getter và setter

}