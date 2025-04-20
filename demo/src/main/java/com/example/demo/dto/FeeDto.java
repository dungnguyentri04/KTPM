package com.example.demo.dto;

import com.example.demo.models.Fee.TypeOfFee;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Fee entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeDto {
    /**
     * Unique identifier of the fee.
     */
    private Long id;

    /**
     * Type of the fee (MANDATORY or NON_MANDATORY).
     */
    private TypeOfFee type;

    /**
     * Name of the fee.
     */
    private String name;

    /**
     * Standard cost associated with the fee.
     */
    private Long costStandard;

    /**
     * Timestamp when the fee was created.
     */
    private Date createdAt;

    /**
     * Timestamp when the fee was last updated.
     */
    private Date updatedAt;
}
