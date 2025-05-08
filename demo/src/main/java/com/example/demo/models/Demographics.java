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
public class Demographics {
    public enum Gender{
        MALE,
        FEMALE,
        OTHER
    }

    public enum Relationship{
        SPOUSE,
        CHILD,
        OWNER,
        PARENT,
        GRANDPARENT,
        OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="household_id")
    private Household household;

    @OneToMany(mappedBy = "demographics",cascade = CascadeType.ALL)
    private List<TemporaryResidence> temporaryResidences;

    @ManyToOne
    @JoinColumn(name="created_user_id")
    private User createdUserId;

    @ManyToOne
    @JoinColumn(name="deleted_user_id")
    private User deletedUserId;

    private Boolean isOwner;

    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    private String name;

    private String alias;

    private Date birthday;

    private Gender sex;

    private String placeOfBirth;

    private String nationality;

    private String countryside;

    private String ethnic;

    private String job;

    private String workplace;

    private String citizenId;

    private String issuingLocation;

    private Date issuingDate;

    private String reasonForMoving;

    private Date movingDate;

    private String reasonForLeaving;

    private Date leavingDate;

    private Date createdAt;

    private Date updatedAt;

}
