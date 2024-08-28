package springdata.week1.springdata.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(name = "nurses")
public class Nurse extends Employee{
    private String rotation;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @OneToOne(mappedBy = "supervisor")
    private Ward supervisedWard;

}
