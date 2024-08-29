package springdata.week1.springdata.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {

    private Long id;

    private String surname;
    private String firstName;
    private String address;
    private String telephoneNumber;
}
