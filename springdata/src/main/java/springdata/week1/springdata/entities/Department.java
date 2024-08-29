package springdata.week1.springdata.entities;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class Department {

    private Long id;
    private String code;
    private String name;
    private String building;

    private Doctor director;

    private List<Ward> wards;
}
