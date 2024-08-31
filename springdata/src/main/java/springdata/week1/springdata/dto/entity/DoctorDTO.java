package springdata.week1.springdata.dto.entity;

import lombok.*;

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
