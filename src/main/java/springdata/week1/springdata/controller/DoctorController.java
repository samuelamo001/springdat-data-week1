package springdata.week1.springdata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;
import springdata.week1.springdata.dto.entity.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long doctorId) {
        DoctorDTO doctorDTO = doctorService.findDoctorById(doctorId);
        return ResponseEntity.ok(doctorDTO);
    }


    @PostMapping()
    public ResponseEntity<String> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = doctorService.cacheDoctorForLaterSave(doctorDTO);
        doctorService.flushDoctorToDatabase(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doctor added and cached for later save");
    }


    @PutMapping("/{doctorId}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDTO doctor) {
        Doctor updatedDoctor = doctorService.updateDoctor(doctorId, doctor);
        return ResponseEntity.ok(updatedDoctor);
    }


    @GetMapping()
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctors = doctorService.finAllDoctors();
        return ResponseEntity.ok(doctors);
    }


    @GetMapping("/patient-count")
    public ResponseEntity<List<DoctorPatientCountDTO>> getDoctorPatientCount() {
        List<DoctorPatientCountDTO> doctorPatientCounts = doctorService.findDoctorsAndPatients();
        return ResponseEntity.ok(doctorPatientCounts);
    }


    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorId) {
        doctorService.deleteDoctorById(doctorId);
        return ResponseEntity.noContent().build();
    }
}
