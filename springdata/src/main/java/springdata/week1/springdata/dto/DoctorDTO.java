package springdata.week1.springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorDTO{
    private Long id;
    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
    private String speciality;
}
