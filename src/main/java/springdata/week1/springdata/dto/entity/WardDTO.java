package springdata.week1.springdata.dto.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WardDTO {
    private Long id;
    private String number;
    private Integer numberOfBeds;
    private Long supervisorId;
    private Long departmentId;
}
