package springdata.week1.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Doctor;

import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;


    public DoctorService(DoctorRepository doctorRepository, DepartmentRepository departmentRepository) {
        this.doctorRepository = doctorRepository;
        this.departmentRepository = departmentRepository;
    }
}
