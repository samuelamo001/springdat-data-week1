package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;


import springdata.week1.springdata.dto.entity.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.mapper.DoctorMapper;
import springdata.week1.springdata.repository.DoctorRepository;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }


    public Page<DoctorDTO> findAllDoctorsPaged(Pageable pageable) {
        return doctorRepository.findAll(pageable)
                .map(doctorMapper::convertToDTO);
    }

    public List<DoctorDTO> finAllDoctorsUnpaged(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors
                .stream()
                .map(doctorMapper::convertToDTO)
                .collect(Collectors.toList());
    }


    public List<DoctorPatientCountDTO> findDoctorsAndPatients() {

        return doctorRepository.findDoctorsAndPatients();
    }

}
