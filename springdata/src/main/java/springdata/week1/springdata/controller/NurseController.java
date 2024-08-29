package springdata.week1.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.NurseDTO;
import springdata.week1.springdata.entities.Nurse;
import springdata.week1.springdata.repository.NurseRepository;
import springdata.week1.springdata.service.NurseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/nurse")
public class NurseController {

    private final NurseService nurseService;

    @PostMapping
    public ResponseEntity<Nurse> createNurse(@RequestBody NurseDTO nurseDTO) {
        Nurse nurse = nurseService.createNurse(nurseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nurse);
    }

    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurses() {
        List<Nurse> nurses = nurseService.getAllNurses();
        return ResponseEntity.ok().body(nurses);
    }

    @PutMapping("/{nurseId}")
    public Nurse updateNurse(@PathVariable Long nurseId, @RequestBody NurseDTO nurseDTO) {
        return nurseService.updateNurse(nurseId, nurseDTO);
    }
}
