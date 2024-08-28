package springdata.week1.springdata.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;


import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;

@Service
@Slf4j
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


   public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
   }

   public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
   }

   public Doctor updateDoctor(Long doctorId, DoctorDTO doctorDTO) {

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setTelephoneNumber(doctorDTO.getTelephoneNumber());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        return doctorRepository.save(doctor);
   }

   public List<Doctor> findDoctorBySpeciality(String speciality) {
        return doctorRepository.findDoctorsBySpeciality(speciality);
   }

   public List<Doctor> findAllDoctorsWithDepartment() {
        return doctorRepository.findAllDoctorsWithDepartments();
   }
}
