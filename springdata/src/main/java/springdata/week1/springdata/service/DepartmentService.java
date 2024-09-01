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
import springdata.week1.springdata.specifications.DepartmentSpecification;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public List<Department> findDepartmentsByCriteria(String building, Long directorId, int minWards) {
        Specification<Department> spec = Specification.where(DepartmentSpecification.hasBuilding(building))
                .and(DepartmentSpecification.hasDirector(directorId))
                .and(DepartmentSpecification.hasWardsGreaterThan(minWards));

        return departmentRepository.findAll(spec);
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
