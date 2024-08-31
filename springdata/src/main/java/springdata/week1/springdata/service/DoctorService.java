package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;


import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<DoctorPatientCountDTO> findDoctorsAndPatients() {

        return doctorRepository.findDoctorsAndPatients();
    }

}
