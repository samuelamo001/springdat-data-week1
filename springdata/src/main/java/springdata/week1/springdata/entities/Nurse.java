package springdata.week1.springdata.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "nurses")
public class Nurse extends Employee{
    private String rotation;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(mappedBy = "supervisor")
    private Ward supervisedWard;

}
