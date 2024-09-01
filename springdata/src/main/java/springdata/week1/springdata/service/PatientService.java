package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.patient.PatientAddressDoctorSpecialityDTO;
import springdata.week1.springdata.dto.patient.PatientDoctorDTO;
import springdata.week1.springdata.dto.patient.PatientNurseDTO;
import springdata.week1.springdata.dto.patient.PatientWardDTO;
import springdata.week1.springdata.entities.Patient;
import springdata.week1.springdata.repository.PatientRepository;
import springdata.week1.springdata.specifications.PatientSpecification;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> findPatientsByCriteria(String diagnosis, Long doctorId, Long wardId) {
        Specification<Patient> spec = Specification.where(PatientSpecification.hasDiagnosis(diagnosis))
                .and(PatientSpecification.treatedByDoctor(doctorId))
                .and(PatientSpecification.isInWard(wardId));

        return patientRepository.findAll(spec);
    }

    public List<PatientDoctorDTO> findPatientsAndDoctors() {
        return patientRepository.findPatientsAndDoctors();
    }

    public List<PatientWardDTO> findPatientsAndWards() {
        return patientRepository.findPatientsAndWards();
    }

    public List<PatientAddressDoctorSpecialityDTO > findPatientsAndAddressAndDoctorSpeciality() {
        return patientRepository.findPatientsAndAddressAndDoctorSpeciality();

    }

   public List<PatientNurseDTO> findPatientsAndNurses() {
        return patientRepository.findPatientsAndNurses();
    }

}
