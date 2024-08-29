package springdata.week1.springdata.entities;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class Ward {

    private Long id;
    private String number;
    private Integer numberOfBeds;

    private Nurse supervisor;


    private Department department;

    private Set<Patient> patients;
}
