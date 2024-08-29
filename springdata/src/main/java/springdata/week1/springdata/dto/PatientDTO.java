package springdata.week1.springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.entities.Ward;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDTO {
    private String id;
    private String name;
    private String surname;
    private String address;
    private String telephone;
    private String diagnosis;
    private Integer bedNumber;
    private Long wardId;
    private Long doctorId;
}
