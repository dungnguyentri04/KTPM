package com.example.demo.dto.RequestDto;

import com.example.demo.models.Demographics.Relationship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdMemberDto {
    private Long id;

    private Boolean isOwner;

    private String relationship;
}
