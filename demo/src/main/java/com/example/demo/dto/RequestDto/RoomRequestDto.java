package com.example.demo.dto.RequestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequestDto {
    @NotBlank(message = "Room name is required")
    private String name;

    @NotNull(message = "Room description is required")
    private String description;

    @NotNull(message = "Room area is required")
    private Float area;

    @NotBlank(message = "Room location is required")
    private String location;

    @NotNull(message = "Household id is required")
    private Long householdId;
}
