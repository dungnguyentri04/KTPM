@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdMemberDto {

    @NotNull(message = "Id is required")
    private Long id;

    private Boolean isOwner;

    @NotBlank(message = "Relationship is required")
    private String relationship;

    private LocalDate joinedDate;

    private LocalDate leftDate;

    private String note;

    private String job
}
