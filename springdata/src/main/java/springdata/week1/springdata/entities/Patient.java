package springdata.week1.springdata.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "patients", indexes = {
        @Index(name = "idx_patient_doctor_id", columnList = "doctor_id"),
        @Index(name = "idx_patient_ward_id", columnList = "ward_id")
})
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String surname;
    private String address;
    private String telephone;
    private String diagnosis;
    private Integer bedNumber;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor treatingDoctor;
}
