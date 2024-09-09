package springdata.week1.springdata.service;

import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.patient.PatientAddressDoctorSpecialityDTO;
import springdata.week1.springdata.dto.patient.PatientDoctorDTO;
import springdata.week1.springdata.dto.patient.PatientNurseDTO;
import springdata.week1.springdata.dto.patient.PatientWardDTO;
import springdata.week1.springdata.repository.PatientRepository;


import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
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
