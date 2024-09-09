package springdata.week1.springdata.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;
import springdata.week1.springdata.dto.entity.DoctorDTO;
import springdata.week1.springdata.service.DoctorService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {


    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/paged-doctors")
    public Page<DoctorDTO> getAllDoctorsPaged(Pageable pageable) {
        return doctorService.findAllDoctorsPaged(pageable);
    }


    @GetMapping()
    List<DoctorDTO> getAllDoctorsUnPaged(){
        return doctorService.finAllDoctorsUnpaged();
    }

    @GetMapping("/patient-count")
    public List<DoctorPatientCountDTO> getDoctorPatientCount() {
        return doctorService.findDoctorsAndPatients();
    }

}
