package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.DoctorDTO;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DoctorRepository;
import springdata.week1.springdata.service.DoctorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {


    private final DoctorService doctorService;






}
