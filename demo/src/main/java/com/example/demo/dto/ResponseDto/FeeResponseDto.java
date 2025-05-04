package com.example.demo.dto.ResponseDto;

import com.example.demo.models.Fee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeResponseDto {
    private Long id;

    private Fee.TypeOfFee type;

    private String name;

    private Long costStandard;

    private Date createdAt;

    private Date updatedAt;
}
