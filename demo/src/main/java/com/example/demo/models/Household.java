package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "household")
    private List<Demographics> demographicsList;

    private String ownerName;

    private String numberOfHousehold;

    private String location;

    private Integer areaCode;

    private Integer numberOfPeople;

    private Date createdAt;

    private Date updateAt;

    private String citizenIdOwner;

}
