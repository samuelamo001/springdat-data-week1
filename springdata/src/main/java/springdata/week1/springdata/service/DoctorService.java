package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;


import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DoctorRepository;
import springdata.week1.springdata.specifications.DoctorSpecification;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> findDoctorsByCriteria(String speciality, Integer minPatients, Long departmentId) {
        Specification<Doctor> spec = Specification.where(DoctorSpecification.hasSpeciality(speciality))
                .and(DoctorSpecification.hasPatientsGreaterThan(minPatients))
                .and(DoctorSpecification.worksInDepartment(departmentId));

        return doctorRepository.findAll(spec);
    }

    public List<DoctorPatientCountDTO> findDoctorsAndPatients() {

        return doctorRepository.findDoctorsAndPatients();
    }

}
