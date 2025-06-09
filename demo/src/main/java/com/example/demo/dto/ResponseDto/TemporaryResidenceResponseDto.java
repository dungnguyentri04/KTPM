package com.example.demo.dto.ResponseDto;

import com.example.demo.models.TemporaryResidence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemporaryResidenceResponseDto {
    private TemporaryResidence.ResidenceType type;

    private String placeOfRegistation;

    private String location;

    private LocalDate startedDate;

    private LocalDate endedDate;

    private LocalDate dateOfRegistation;

    private String reason;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String roomName;

    private long id;

    private long demographicId;

    private String demographicName;

}
