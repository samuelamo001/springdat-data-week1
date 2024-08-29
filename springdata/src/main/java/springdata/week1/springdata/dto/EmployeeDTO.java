package springdata.week1.springdata.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private Long id;
    @NotBlank
    private String surname;
    @NotBlank
    private String firstName;
    @NotBlank
    private String address;
    @NotBlank
    private String telephoneNumber;
}
