package com.example.demo.dto;

import com.example.demo.models.Demographics.Gender;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Demographics entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicsDto {
    private Long id;


    private HouseholdDto household;


    private List<TemporaryResidenceDto> temporaryResidenceIds;


    private UserDto createdUser;


    private UserDto deletedUser;

    /**
     * Whether this person is the owner of the household.
     */
    private Boolean isOwner;

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
