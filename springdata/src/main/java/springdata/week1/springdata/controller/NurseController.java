package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springdata.week1.springdata.dto.nurse.NurseDepartmentDTO;
import springdata.week1.springdata.dto.nurse.NurseDirectorDTO;
import springdata.week1.springdata.dto.nurse.NurseWardDTO;
import springdata.week1.springdata.entities.Nurse;
import springdata.week1.springdata.service.NurseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nurse")
public class NurseController {

    private final NurseService nurseService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @RequestMapping("/department")
    public List<NurseDepartmentDTO> getNurseDepartment() {
        return nurseService.findNursesAndDepartments();
    }

    @GetMapping("/ward")
    public List<NurseWardDTO> getNurseWard() {
        return nurseService.findNursesAndWards();
    }

    @GetMapping("/director")
    public List<NurseDirectorDTO> getNurseDirector() {
        return nurseService.findNursesAndDirectors();
    }

}
