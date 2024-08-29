package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.PatientDTO;
import springdata.week1.springdata.entities.Patient;
import springdata.week1.springdata.repository.PatientRepository;
import springdata.week1.springdata.service.PatientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;


    @PostMapping
    public Patient createPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable("patientId") Long patientId, @RequestBody PatientDTO patientDTO) {
        return patientService.updatePatient(patientId, patientDTO);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @GetMapping("/{patientId}")
    public PatientDTO getPatientById(@PathVariable("patientId") Long patientId) {
        return patientService.getPatientById(patientId);
    }
}
