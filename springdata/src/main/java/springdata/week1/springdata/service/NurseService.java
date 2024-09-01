package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.nurse.NurseDepartmentDTO;
import springdata.week1.springdata.dto.nurse.NurseDirectorDTO;
import springdata.week1.springdata.dto.nurse.NurseWardDTO;
import springdata.week1.springdata.entities.Nurse;
import springdata.week1.springdata.repository.NurseRepository;
import springdata.week1.springdata.specifications.NurseSpecification;

import java.util.List;


@RequiredArgsConstructor
@Service
public class NurseService {

    private final NurseRepository nurseRepository;

    public List<Nurse> findNursesByCriteria(Long departmentId, Double minSalary, boolean isSupervisor) {
        Specification<Nurse> spec = Specification.where(NurseSpecification.worksInDepartment(departmentId))
                .and(NurseSpecification.hasSalaryGreaterThan(minSalary));

        if (isSupervisor) {
            spec = spec.and(NurseSpecification.isSupervisor());
        }

        return nurseRepository.findAll(spec);
    }

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
