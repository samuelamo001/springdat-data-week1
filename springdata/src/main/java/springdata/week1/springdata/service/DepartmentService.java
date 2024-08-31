package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.department.DepartmentAverageNurseSalaryDTO;
import springdata.week1.springdata.dto.department.DepartmentDirectorDTO;
import springdata.week1.springdata.dto.department.DepartmentNurseCountDTO;
import springdata.week1.springdata.dto.department.DepartmentWardCountDTO;
import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;


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
