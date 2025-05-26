package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fee {
    public enum TypeOfFee{
        NON_MANDATORY,
        MANDATORY
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TypeOfFee type;

    private String name;

    private Long costStandard;

    private LocalDate createdAt;

    private LocalDate updatedAt;

}
