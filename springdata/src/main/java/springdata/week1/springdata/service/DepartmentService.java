package springdata.week1.springdata.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.dto.DepartmentDirectorDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Doctor;
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

}
