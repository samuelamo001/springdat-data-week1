package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.department.DepartmentAverageNurseSalaryDTO;
import springdata.week1.springdata.dto.department.DepartmentDirectorDTO;
import springdata.week1.springdata.dto.department.DepartmentNurseCountDTO;
import springdata.week1.springdata.dto.department.DepartmentWardCountDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.DoctorRepository;


import java.util.List;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<DepartmentDirectorDTO> findDepartmentDirectorsByDepartmentName() {
        return departmentRepository.findDepartmentDirectorsByDepartmentName();
    }

    public List<DepartmentWardCountDTO> findDepartmentsAndWardCount(){
        return departmentRepository.findDepartmentsAndWardCount();
    }

    public List<DepartmentNurseCountDTO> findDepartmentsAndNurseCount(){
        return departmentRepository.findDepartmentsAndNurseCount();
    }

    public List<DepartmentAverageNurseSalaryDTO> findDepartmentsAndAverageNurseSalary(){
        return departmentRepository.findDepartmentsAndAverageNurseSalary();
    }
}
