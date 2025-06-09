@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeRequestDto {

    @NotBlank(message = "Fee type is required")
    private String type;

    @NotBlank(message = "Fee name is required")
    private String name;

    @NotNull(message = "Fee cost standard is required")
    @Positive(message = "Fee cost must be greater than 0")
    private Long costStandard;

    private String description;

    @NotNull(message = "Fee start date is required")
    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean isMandatory;
}
