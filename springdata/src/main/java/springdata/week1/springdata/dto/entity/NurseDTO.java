package springdata.week1.springdata.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NurseDTO {
    private Long id;
    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
    private String rotation;
    private Double salary;
    private Long departmentId;
}
