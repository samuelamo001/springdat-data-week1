package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Doctor doctor = doctorRepository.findById(departmentDTO.getDirectorId()).orElseThrow(()-> new RuntimeException("Doctor not found"));
        Department department = Department.builder()
                .code(departmentDTO.getCode())
                .name(departmentDTO.getName())
                .building(departmentDTO.getBuilding())
                .director(doctor)
                .build();

        return departmentRepository.save(department);

    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
