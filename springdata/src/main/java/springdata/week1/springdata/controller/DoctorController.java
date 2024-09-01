package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.service.DoctorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {


    private final DoctorService doctorService;


    @GetMapping("/patient-count")
    public List<DoctorPatientCountDTO> getDoctorPatientCount() {
        return doctorService.findDoctorsAndPatients();
    }

    @GetMapping("/search")
    public List<Doctor> findDoctorsByCriteria(
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) Integer minPatients,
            @RequestParam(required = false) Long departmentId) {
        return doctorService.findDoctorsByCriteria(specialization, minPatients, departmentId);
    }
}
