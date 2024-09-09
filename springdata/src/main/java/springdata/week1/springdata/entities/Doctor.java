package springdata.week1.springdata.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "doctors", indexes = {
        @Index(name = "idx_doctor_speciality", columnList = "speciality"),
        @Index(name = "idx_doctor_employee_id", columnList = "id")
})
public class Doctor extends Employee{
    private String speciality;

    @JsonIgnore
    @OneToMany(mappedBy = "treatingDoctor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Patient> patients;

    @JsonIgnore
    @OneToOne(mappedBy = "director")
    private Department directedDepartment;

}
