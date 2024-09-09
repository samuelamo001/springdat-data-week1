package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.ward.WardDepartmentDTO;
import springdata.week1.springdata.dto.ward.WardDirectorDTO;
import springdata.week1.springdata.dto.ward.WardPatientCountDTO;
import springdata.week1.springdata.entities.Ward;
import springdata.week1.springdata.repository.WardRepository;
import springdata.week1.springdata.specifications.WardSpecification;

import java.util.List;


@Service
public class WardService {

    private final WardRepository wardRepository;

    public WardService(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    public List<Ward> findWardsByCriteria(String number, int minBeds, Long departmentId) {
        Specification<Ward> spec = Specification.where(WardSpecification.hasNumber(number))
                .and(WardSpecification.hasBedsGreaterThan(minBeds))
                .and(WardSpecification.belongsToDepartment(departmentId));

        return wardRepository.findAll(spec);
    }


    public List<WardPatientCountDTO> findWardsAndPatientCount(String wardNumber) {
        return wardRepository.findWardsAndPatientCount(wardNumber);
    }

    public List<WardDepartmentDTO> findWardsAndDepartments(String wardNumber) {
        return wardRepository.findWardsAndDepartments(wardNumber);
    }

    public List<WardDirectorDTO> findWardsAndDirectors(String wardNumber) {
        return wardRepository.findWardsAndDirectors(wardNumber);
    }
}
