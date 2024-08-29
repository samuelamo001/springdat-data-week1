package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.PatientDTO;
import springdata.week1.springdata.entities.Patient;
import springdata.week1.springdata.service.PatientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.createPatient(patientDTO);
        return ResponseEntity.ok().body(patient);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("patientId") Long patientId, @RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.updatePatient(patientId, patientDTO);
        return ResponseEntity.ok().body(patient);
    }

}
