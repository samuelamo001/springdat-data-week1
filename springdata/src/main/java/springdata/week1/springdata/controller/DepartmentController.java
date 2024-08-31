package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.dto.DepartmentDirectorDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.service.DepartmentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping("/directors")
    public List<DepartmentDirectorDTO> getDepartmentDirectors() {

        return departmentService.findDepartmentDirectorsByDepartmentName();
    }


}
