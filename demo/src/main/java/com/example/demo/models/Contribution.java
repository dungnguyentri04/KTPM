package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "household_book_id")
    private Household household;

    private double money;

    private double price;

    private StatusContribution status;

    private Date paymentDate;

    private Date deadline;

    @Column(columnDefinition = "json")
    private String attributes;

    private Date createdAt;

    private Date updateAt;

}
