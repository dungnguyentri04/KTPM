package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contribution {
    public enum StatusContribution{
        COMPLETE,
        IN_COMPLETE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fee_id")
    private Fee fee;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    private double money;

    private String feeName;

    private double price;

    @Enumerated(EnumType.STRING)
    private StatusContribution status;

    private LocalDate paymentDate;

    private LocalDate deadline;

    @Column(columnDefinition = "json")
    private String attributes;

    private LocalDate createdAt;

    private LocalDate updateAt;

}
