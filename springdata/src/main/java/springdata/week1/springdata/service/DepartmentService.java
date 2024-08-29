package springdata.week1.springdata.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;


    public DepartmentService(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }
    public Department createDepartment(DepartmentDTO departmentDTO) {
        Doctor doctor = doctorRepository.findById(departmentDTO.getDirector()).orElseThrow(()-> new EntityNotFoundException("Not found"));
        Department department = Department.builder()
                .name(departmentDTO.getName())
                .code(departmentDTO.getCode())
                .building(departmentDTO.getBuilding())
                .director(doctor)
                .build();

        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }




}
