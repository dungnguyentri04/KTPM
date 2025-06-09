@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeResponseDto {

    private Long id;

    private Fee.TypeOfFee type;

    private String name;

    private Long costStandard;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String description;

    private Boolean isMandatory;

    private LocalDate startDate;

    private LocalDate endDate;
}
