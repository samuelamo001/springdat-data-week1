package springdata.week1.springdata.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Setter
@Getter
@Builder
@Document(collection = "departments")
public class Department {

    @MongoId
    private String id;
    private String code;
    private String name;
    private String building;

    @JsonIgnore
    @DBRef
    private Doctor director;
    @JsonIgnore
    private List<Ward> wards;
}
