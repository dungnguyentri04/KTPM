package com.example.demo.dto.RequestDto;

import com.example.demo.models.Demographics.Relationship;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdMemberDto {
    @NotNull(message = "Id is required")
    private Long id;

    private Boolean isOwner;

    @NotNull(message = "Relationship is required")
    private String relationship;
}
