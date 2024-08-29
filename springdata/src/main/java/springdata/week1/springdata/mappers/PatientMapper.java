package springdata.week1.springdata.mappers;

import org.springframework.stereotype.Component;
import springdata.week1.springdata.dto.PatientDTO;
import springdata.week1.springdata.entities.Patient;

@Component
public class PatientMapper {

    public PatientDTO convertToDTO(Patient patient) {
        return PatientDTO.builder()
                .name(patient.getName())
                .surname(patient.getSurname())
                .address(patient.getAddress())
                .telephone(patient.getTelephone())
                .diagnosis(patient.getDiagnosis())
                .bedNumber(patient.getBedNumber())
                .build();
    }
}
