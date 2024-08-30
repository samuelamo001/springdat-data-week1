package springdata.week1.springdata.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentDTO {
    private String id;
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String building;
    @NotBlank
    private String directorId;

}
