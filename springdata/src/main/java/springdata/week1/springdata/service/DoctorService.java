package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.mappers.DoctorMapper;
import springdata.week1.springdata.repository.DoctorRepository;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

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


    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors
                .stream()
                .map(doctorMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(String doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new RuntimeException("Doctor not found"));
        return doctorMapper.convertToDTO(doctor);
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
