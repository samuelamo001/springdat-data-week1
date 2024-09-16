package springdata.week1.springdata.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "wards", indexes = {
        @Index(name = "idx_ward_number", columnList = "number"),
        @Index(name = "idx_ward_department_id", columnList = "department_id")
})
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Integer numberOfBeds;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "ward", fetch = FetchType.LAZY)
    private Set<Patient> patients;
}



