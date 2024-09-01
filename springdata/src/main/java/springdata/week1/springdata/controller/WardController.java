package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springdata.week1.springdata.dto.ward.WardDepartmentDTO;
import springdata.week1.springdata.dto.ward.WardDirectorDTO;
import springdata.week1.springdata.dto.ward.WardPatientCountDTO;
import springdata.week1.springdata.entities.Ward;
import springdata.week1.springdata.service.WardService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/ward")
public class WardController {

    private final WardService wardService;


    @GetMapping("/patient-count")
    public List<WardPatientCountDTO> getWardPatientCount(@RequestParam(required = false) String wardNumber) {
        return wardService.findWardsAndPatientCount(wardNumber);
    }

    @RequestMapping("/department")
    public List<WardDepartmentDTO> getWardDepartment(@RequestParam(required = false) String wardNumber) {
        return wardService.findWardsAndDepartments(wardNumber);
    }

    @GetMapping("/director")
    public List<WardDirectorDTO> getWardDirector(@RequestParam(required = false) String wardNumber) {
        return wardService.findWardsAndDirectors(wardNumber);


    }
}
