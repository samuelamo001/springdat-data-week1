package springdata.week1.springdata.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class EmployeeDTO {

    private String id;
    @NotBlank
    private String surname;
    @NotBlank
    private String firstName;
    @NotBlank
    private String address;
    @NotBlank
    private String telephoneNumber;
}
