package springdata.week1.springdata.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Getter
@Setter
@Document(collection = "wards")
public class Ward {

    @MongoId
    private String id;
    private String number;
    private Integer numberOfBeds;

    @DBRef
    private Nurse supervisor;

    @DBRef
    private Department department;

    private Set<Patient> patients;
}
