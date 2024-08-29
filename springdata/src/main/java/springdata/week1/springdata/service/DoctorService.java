package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DoctorRepository;

import javax.print.Doc;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = Doctor.builder()
                .surname(doctorDTO.getSurname())
                .firstName(doctorDTO.getFirstName())
                .address(doctorDTO.getAddress())
                .telephoneNumber(doctorDTO.getTelephoneNumber())
                .speciality(doctorDTO.getSpeciality())
                .build();

        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(String doctorId, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setSurname(doctorDTO.getSurname());
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setTelephoneNumber(doctorDTO.getTelephoneNumber());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        return doctorRepository.save(doctor);

    }
}
