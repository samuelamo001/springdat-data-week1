package springdata.week1.springdata.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

@Document(collection = "patients")
public class Patient {

    @MongoId
    private String id;
    private String name;
    private String surname;
    private String address;
    private String telephone;
    private String diagnosis;
    private Integer bedNumber;

    @DBRef
    private Ward ward;
    @DBRef
    private Doctor treatingDoctor;
}
