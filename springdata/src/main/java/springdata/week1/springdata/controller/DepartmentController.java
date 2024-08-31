package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.department.DepartmentAverageNurseSalaryDTO;
import springdata.week1.springdata.dto.department.DepartmentDirectorDTO;
import springdata.week1.springdata.dto.department.DepartmentNurseCountDTO;
import springdata.week1.springdata.dto.department.DepartmentWardCountDTO;
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


    @GetMapping("/ward-count")
    public List<DepartmentWardCountDTO> getDepartmentWardCount() {
        return departmentService.findDepartmentsAndWardCount();
    }

    @GetMapping("/nurse-count")
    public List<DepartmentNurseCountDTO> getDepartmentNurseCount() {
        return departmentService.findDepartmentsAndNurseCount();
    }

    @GetMapping("/average-nurse-salary")
    public List<DepartmentAverageNurseSalaryDTO> getDepartmentAverageNurseSalary() {
        return departmentService.findDepartmentsAndAverageNurseSalary();
    }



}
