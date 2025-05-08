package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "household",cascade = CascadeType.ALL)
    private List<Demographics> demographicsList = new ArrayList<>();

    private Long ownerId;

    private String ownerName;

    private String citizenIdOwner;

    private String numberOfHousehold;

    private String location;

    private int areaCode;

    private int numberOfPeople;

    private Date createdAt;

    private Date updateAt;

}
