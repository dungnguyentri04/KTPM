package com.example.demo.dto.RequestDto;

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
public class FeeRequestDto {
    private TypeOfFee type;

    private String name;

    private Long costStandard;
}
