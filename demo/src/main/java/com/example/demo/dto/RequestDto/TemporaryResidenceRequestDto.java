package com.example.demo.dto.RequestDto;

import com.example.demo.models.TemporaryResidence.ResidenceType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for TemporaryResidence entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemporaryResidenceRequestDto {
    /**
     * Unique identifier of the temporary residence record.
     */
    private Long id;

    /**
     * ID of the associated Demographics record.
     */
    private DemographicsRequestDto demographics;

    /**
     * Type of residence: TEMPORARY_RESIDENCE or TEMPORARY_ABSENCE.
     */
    private ResidenceType type;

    /**
     * Place where the registration occurred.
     */
    private String placeOfRegistration;

    /**
     * Location address for the temporary residence.
     */
    private String location;

    /**
     * Date when the temporary residence started.
     */
    private Date startedDate;

    /**
     * Date when the temporary residence ended.
     */
    private Date endedDate;

    /**
     * Date when the registration was recorded.
     */
    private Date dateOfRegistration;

    /**
     * Reason for the temporary residence or absence.
     */
    private String reason;

    /**
     * Timestamp when the record was created.
     */
    private Date createdAt;

    /**
     * Timestamp when the record was last updated.
     */
    private Date updatedAt;
}