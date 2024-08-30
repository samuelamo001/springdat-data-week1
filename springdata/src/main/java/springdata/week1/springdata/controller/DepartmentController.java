package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.service.DepartmentService;

import java.util.List;

@RestController@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody DepartmentDTO department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public DepartmentDTO getDepartment(@PathVariable String departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable String departmentId, @RequestBody DepartmentDTO departmentDTO) {
        return departmentService.updateDepartment(departmentId, departmentDTO);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable String departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
