package springdata.week1.springdata.dto;

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
    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
}
