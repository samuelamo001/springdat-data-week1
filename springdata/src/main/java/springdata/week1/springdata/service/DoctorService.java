package springdata.week1.springdata.service;

import jakarta.persistence.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;


import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;

@Service
@Slf4j
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public Doctor createDoctor(DoctorDTO doctorDTO) {
     Doctor doctor = Doctor.builder()
             .firstName(doctorDTO.getFirstName())
             .surname(doctorDTO.getSurname())
             .address(doctorDTO.getAddress())
             .telephoneNumber(doctorDTO.getTelephoneNumber())
             .speciality(doctorDTO.getSpeciality())
             .build();
     log.info("doctor to be saved: {}", doctor.getSpeciality());

     return doctorRepository.save(doctor);
 }

 public Doctor findDoctorByPatientId(Long patientId) {
        return doctorRepository.findDoctorByPatient(patientId);
 }

 public List<Doctor> findBySpeciality(String speciality) {
        return doctorRepository.findDoctorsBySpeciality(speciality);
 }



   public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
   }

   public void deleteDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(doctorDTO.getId()).orElseThrow();
        doctorRepository.delete(doctor);
   }


}
