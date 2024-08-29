package springdata.week1.springdata.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor treatingDoctor;
}
