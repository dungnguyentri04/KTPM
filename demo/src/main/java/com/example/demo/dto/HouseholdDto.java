package com.example.demo.dto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Household entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdDto {
    /**
     * Unique identifier of the household.
     */
    private Long id;

    /**
     * List of Demographics record IDs belonging to this household.
     */
    private List<DemographicsDto> demographicsList;

    /**
     * Name of the household owner.
     */
    private String ownerName;

    /**
     * Registered household number.
     */
    private String numberOfHousehold;

    /**
     * Location/address of the household.
     */
    private String location;

    /**
     * Area code of the household's region.
     */
    private Integer areaCode;

    /**
     * Total number of people in the household.
     */
    private Integer numberOfPeople;

    /**
     * Timestamp when the household record was created.
     */
    private Date createdAt;

    /**
     * Timestamp when the household record was last updated.
     */
    private Date updateAt;

    /**
     * Citizen ID of the household owner.
     */
    private String citizenIdOwner;
}