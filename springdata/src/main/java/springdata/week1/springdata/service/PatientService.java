package springdata.week1.springdata.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.PatientDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.entities.Patient;
import springdata.week1.springdata.entities.Ward;
import springdata.week1.springdata.mappers.PatientMapper;
import springdata.week1.springdata.repository.DoctorRepository;
import springdata.week1.springdata.repository.PatientRepository;
import springdata.week1.springdata.repository.WardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final WardRepository wardRepository;
    private final DoctorRepository doctorRepository;
    private final PatientMapper patientMapper;

    @Transactional
    public Patient createPatient(PatientDTO patientDTO) {

        Ward ward = wardRepository.findById(patientDTO.getWardId()).orElseThrow(() -> new RuntimeException("Ward not found"));
        Doctor doctor = doctorRepository.findById(patientDTO.getDoctorId()).orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = Patient.builder()
                .name(patientDTO.getName())
                .surname(patientDTO.getSurname())
                .address(patientDTO.getAddress())
                .telephone(patientDTO.getTelephone())
                .diagnosis(patientDTO.getDiagnosis())
                .bedNumber(patientDTO.getBedNumber())
                .ward(ward)
                .treatingDoctor(doctor)
                .build();

        return patientRepository.save(patient);
    }

    @Cacheable(value = "patients")
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients
                .stream()
                .map(patientMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "patients", key = "#patientId")
    public PatientDTO getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        return patientMapper.convertToDTO(patient);
    }

    @Transactional
    @CachePut(value = "patients", key = "#patientId")
    public Patient updatePatient(Long patientId, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setAddress(patientDTO.getAddress());
        patient.setTelephone(patientDTO.getTelephone());
        patient.setDiagnosis(patientDTO.getDiagnosis());
        patient.setBedNumber(patientDTO.getBedNumber());
        return patientRepository.save(patient);
    }

    @CacheEvict(value = "patients", key = "#patientId")
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }
}
