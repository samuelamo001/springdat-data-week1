package springdata.week1.springdata.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor extends Employee{
    private String speciality;

    @JsonIgnore
    @OneToMany(mappedBy = "treatingDoctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Patient> patients;

    @JsonIgnore
    @OneToOne(mappedBy = "director")
    private Department directedDepartment;
}
