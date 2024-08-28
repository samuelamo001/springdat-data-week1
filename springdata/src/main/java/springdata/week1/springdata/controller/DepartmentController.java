package springdata.week1.springdata.controller;

import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.createDepartment(departmentDTO);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public Department getDepartment(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("{departmentId}")
    public void deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable Long departmentId, @RequestBody DepartmentDTO departmentDTO) {
        return departmentService.updateDepartment(departmentId, departmentDTO);
    }
}
