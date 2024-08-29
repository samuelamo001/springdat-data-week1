package springdata.week1.springdata.dto;

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
    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
}
