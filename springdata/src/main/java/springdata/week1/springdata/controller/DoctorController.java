package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DoctorRepository;
import springdata.week1.springdata.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {


    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor createDoctor(DoctorDTO doctorDTO) {
        return doctorService.createDoctor(doctorDTO);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    @GetMapping("/speciality")
    public List<Doctor> findBySpeciality(@RequestParam String speciality) {
        return doctorService.findBySpeciality(speciality);
    }

    @GetMapping("/patient/{patientId}")
    public Doctor findDoctorByPatientId(@PathVariable Long patientId) {
        return doctorService.findDoctorByPatientId(patientId);
    }


}
