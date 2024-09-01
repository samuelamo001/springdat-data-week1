package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springdata.week1.springdata.dto.patient.PatientAddressDoctorSpecialityDTO;
import springdata.week1.springdata.dto.patient.PatientDoctorDTO;
import springdata.week1.springdata.dto.patient.PatientNurseDTO;
import springdata.week1.springdata.dto.patient.PatientWardDTO;
import springdata.week1.springdata.service.PatientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/doctor")
    public List<PatientDoctorDTO> getPatientsAndDoctors() {
        return patientService.findPatientsAndDoctors();
    }

    @GetMapping("/ward")
    public List<PatientWardDTO> getPatientsAndWards() {
        return patientService.findPatientsAndWards();
    }

    @GetMapping("/address-doctor-speciality")
    public List<PatientAddressDoctorSpecialityDTO> getPatientsAndAddressAndSpeciality() {
        return patientService.findPatientsAndAddressAndDoctorSpeciality();
    }

    @GetMapping("/nurse")
    public List<PatientNurseDTO> getPatientsAndNurses() {
        return patientService.findPatientsAndNurses();
    }
}
