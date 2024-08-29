package springdata.week1.springdata.mappers;

import org.springframework.stereotype.Component;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.entities.Department;

@Component
public class DepartmentMapper {

    public DepartmentDTO convertToDTO(Department department) {
        return DepartmentDTO.builder()
                .code(department.getCode())
                .name(department.getName())
                .building(department.getBuilding())
                .build();
    }
}
