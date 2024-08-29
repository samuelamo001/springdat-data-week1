package springdata.week1.springdata.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;


import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;


    public Doctor createDoctor(DoctorDTO doctorDTO) {
     Doctor doctor = Doctor.builder()
             .firstName(doctorDTO.getFirstName())
             .surname(doctorDTO.getSurname())
             .address(doctorDTO.getAddress())
             .telephoneNumber(doctorDTO.getTelephoneNumber())
             .speciality(doctorDTO.getSpeciality())
             .build();

     return doctorRepository.save(doctor);
 }

}
