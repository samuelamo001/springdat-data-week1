package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DoctorRepository;
import springdata.week1.springdata.service.DoctorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public Doctor createDoctor(@RequestBody DoctorDTO doctorDTO){
        return doctorService.createDoctor(doctorDTO);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PutMapping("/{doctorId}")
    public Doctor updateDoctor(@PathVariable String doctorId, @RequestBody DoctorDTO doctorDTO){
        return doctorService.updateDoctor(doctorId, doctorDTO);
    }

}
