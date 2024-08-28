package springdata.week1.springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Ward;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
