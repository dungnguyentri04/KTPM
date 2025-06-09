
package com.example.demo.dto.RequestDto;

import com.example.demo.models.Fee.TypeOfFee;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeRequestDto {

    @NotBlank(message = "Fee type is required")
    private String type;

    @NotBlank(message = "Fee name is required")
    private String name;

    @NotNull(message = "Fee cost standard is required")

    private Long costStandard;

    private String description;

    @NotNull(message = "Fee start date is required")
    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean isMandatory;
}
