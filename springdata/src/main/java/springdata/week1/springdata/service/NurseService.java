package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.nurse.NurseDepartmentDTO;
import springdata.week1.springdata.dto.nurse.NurseDirectorDTO;
import springdata.week1.springdata.dto.nurse.NurseWardDTO;
import springdata.week1.springdata.repository.NurseRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
public class NurseService {

    private final NurseRepository nurseRepository;

    public List<NurseDepartmentDTO> findNursesAndDepartments() {
        return nurseRepository.findNursesAndDepartments();
    }

    public List<NurseWardDTO> findNursesAndWards() {
        return nurseRepository.findNursesAndWards();
    }

    public List<NurseDirectorDTO> findNursesAndDirectors() {
        return nurseRepository.findNursesAndDirectors();
    }

}
