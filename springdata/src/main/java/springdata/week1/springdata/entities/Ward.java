package springdata.week1.springdata.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "wards")
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String number;
    private Integer numberOfBeds;

    @OneToOne
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;

    @ManyToOne()
    @JoinColumn(name = "department_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @OneToMany(mappedBy = "ward")
    private Set<Patient> patients;
}
