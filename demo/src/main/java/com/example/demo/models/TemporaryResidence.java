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
public class TemporaryResidence {
    public enum ResidenceType {
        TEMPORARY_RESIDENCE,
        TEMPORARY_ABSENCE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="demographics_id")
    private Demographics demographics;

    private ResidenceType type;

    private String placeOfRegistation;

    private String location;

    private Date startedDate;

    private Date endedDate;

    private Date dateOfRegistation;

    private String reason;

    private Date createdAt;

    private Date updatedAt;

}
