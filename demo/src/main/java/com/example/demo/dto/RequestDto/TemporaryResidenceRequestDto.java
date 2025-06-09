package com.example.demo.dto.RequestDto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemporaryResidenceRequestDto {
    @NotNull(message = "Demographic id is required")
    private long demographicId;

    @NotNull(message = "Residence type is required")
    private String type;

    private String placeOfRegistration;

    private String location;

    @NotNull(message = "Started date is required")
    private LocalDate startedDate;

    @NotNull(message = "Ended date is required")
    private LocalDate endedDate;

    private LocalDate dateOfRegistration;

    @NotNull(message = "Reason is required")
    private String reason;

    private String roomName;

    private String registeredBy;

    private Boolean isApproved;

    private String approverName;

    private LocalDate approvalDate;

    private String contactAddress;

    private String contactPhone;

    private String idDocumentNumber;

    private String issuedPlace;

    private LocalDate issuedDate;

    private String note;
}
