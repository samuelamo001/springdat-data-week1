package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import springdata.week1.springdata.dto.PatientDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.entities.Patient;
import springdata.week1.springdata.entities.Ward;
import springdata.week1.springdata.repository.DoctorRepository;
import springdata.week1.springdata.repository.PatientRepository;
import springdata.week1.springdata.repository.WardRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;
    private final WardRepository wardRepository;
    private final DoctorRepository doctorRepository;
    private final PlatformTransactionManager transactionManager;

    public Patient createPatient(PatientDTO patientDTO) {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("Patient transaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            Ward ward = wardRepository.findById(patientDTO.getWardId()).orElseThrow(()-> new IllegalArgumentException("Ward not found"));
            log.info("getting ward info: {}", ward.getNumber());

            Doctor doctor = doctorRepository.findById(patientDTO.getDoctorId()).orElseThrow(()-> new IllegalArgumentException("Doctor not found"));
            log.info("getting doctor information: {}", doctor.getSurname());

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
            transactionManager.commit(status);
            return patientRepository.save(patient);

        }catch (Exception exception) {
            transactionManager.rollback(status);
            throw exception;
        }
    }

    @Cacheable("patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    @CacheEvict(value = "patients", allEntries = true)
    public Patient updatePatient(Long patientId, PatientDTO patientDTO) {

        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new IllegalArgumentException("Patient not found"));
        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setAddress(patientDTO.getAddress());
        patient.setTelephone(patientDTO.getTelephone());
        patient.setDiagnosis(patientDTO.getDiagnosis());
        patient.setBedNumber(patientDTO.getBedNumber());

        return patientRepository.save(patient);
    }

}
