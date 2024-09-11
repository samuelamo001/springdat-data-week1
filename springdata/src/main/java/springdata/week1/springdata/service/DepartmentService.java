package springdata.week1.springdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.department.DepartmentAverageNurseSalaryDTO;
import springdata.week1.springdata.dto.department.DepartmentDirectorDTO;
import springdata.week1.springdata.dto.department.DepartmentNurseCountDTO;
import springdata.week1.springdata.dto.department.DepartmentWardCountDTO;
import springdata.week1.springdata.repository.DepartmentRepository;


import java.util.List;


@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

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
