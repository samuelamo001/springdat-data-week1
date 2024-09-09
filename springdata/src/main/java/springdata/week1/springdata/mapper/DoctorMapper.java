package springdata.week1.springdata.mapper;

import org.springframework.stereotype.Component;
import springdata.week1.springdata.dto.entity.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;

@Component
public class DoctorMapper {

    public DoctorDTO convertToDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .id(doctor.getId())
                .surname(doctor.getSurname())
                .firstName(doctor.getFirstName())
                .address(doctor.getAddress())
                .telephoneNumber(doctor.getTelephoneNumber())
                .speciality(doctor.getSpeciality())
                .build();
    }

}
