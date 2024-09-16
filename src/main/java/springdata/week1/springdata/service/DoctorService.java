package springdata.week1.springdata.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.Execptions.doctor.DoctorCreationException;
import springdata.week1.springdata.Execptions.doctor.DoctorNotFoundException;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;
import springdata.week1.springdata.dto.entity.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.mapper.DoctorMapper;
import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Cacheable(value = "doctors", key = "#doctorId")
    public DoctorDTO findDoctorById(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with id " + doctorId + " not found"));

        return doctorMapper.convertToDTO(doctor);
    }


    @Cacheable(value = "doctors", key = "'all_doctors'")
    public List<DoctorDTO> finAllDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();

        logger.info("Doctors have been retrieved from the database successfully");
        return doctors
                .stream()
                .map(doctorMapper::convertToDTO)
                .collect(Collectors.toList());
    }


    @CachePut(value = "doctors", key = "#doctorDTO.surname")
    public Doctor updateDoctor(Long doctorId, DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor with id " + doctorId + " not found"));

        existingDoctor.setFirstName(doctorDTO.getFirstName());
        existingDoctor.setSurname(doctorDTO.getSurname());
        existingDoctor.setAddress(doctorDTO.getAddress());
        existingDoctor.setTelephoneNumber(doctorDTO.getTelephoneNumber());
        existingDoctor.setSpeciality(doctorDTO.getSpeciality());

        logger.info("Doctor with ID {} updated.", doctorId);

        return doctorRepository.save(existingDoctor);
    }

    @CacheEvict(value = "doctors", allEntries = true)
    public void deleteDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new DoctorNotFoundException("Doctor with id " + id + " not found"));
        doctorRepository.delete(doctor);
    }

    @CachePut(value = "doctors", key = "#doctorDTO.surname")
    public Doctor cacheDoctorForLaterSave(DoctorDTO doctorDTO) {
        Doctor doctor = Doctor.builder()
                .surname(doctorDTO.getSurname())
                .firstName(doctorDTO.getFirstName())
                .address(doctorDTO.getAddress())
                .telephoneNumber(doctorDTO.getTelephoneNumber())
                .speciality(doctorDTO.getSpeciality())
                .build();

        logger.info("Doctor cached for later DB save: {}", doctor.getSurname());
        return doctor;

    }

    @Async
    @Transactional
    public void flushDoctorToDatabase(Doctor doctor) {
        doctorRepository.save(doctor);
        logger.info("Doctor asynchronously saved to DB: {}", doctor.getSurname());
    }


    public List<DoctorPatientCountDTO> findDoctorsAndPatients() {
        return doctorRepository.findDoctorsAndPatients();
    }

}
