package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.mappers.DepartmentMapper;
import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final DepartmentMapper departmentMapper;

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

    public DepartmentDTO getDepartment(String departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()-> new RuntimeException("Department not found"));
        return departmentMapper.convertToDTO(department);
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments
                .stream()
                .map(departmentMapper::convertToDTO)
                .collect(Collectors.toList());

    }

    public Department updateDepartment(String departmentId, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()-> new RuntimeException("Department not found"));
        department.setCode(departmentDTO.getCode());
        department.setName(departmentDTO.getName());
        department.setBuilding(departmentDTO.getBuilding());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public List<DepartmentDTO> getDepartmentsByDirector(String directorId) {
        List<Department> departments = departmentRepository.findDepartmentsByDirector(directorId);
        return departments
                .stream()
                .map(departmentMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
