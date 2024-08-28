package springdata.week1.springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Patient;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDTO {
    private Long id;
    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
    private String speciality;
    private Set<PatientDTO> patients;
    private DepartmentDTO directedDepartment;
}
