package springdata.week1.springdata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor extends Employee{
    private String speciality;

    @OneToMany(mappedBy = "treatingDoctor")
    private Set<Patient> patients;

    @OneToOne(mappedBy = "director")
    private Department directedDepartment;
}
