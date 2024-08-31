package springdata.week1.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.ward.WardDepartmentDTO;
import springdata.week1.springdata.dto.ward.WardDirectorDTO;
import springdata.week1.springdata.dto.ward.WardPatientCountDTO;
import springdata.week1.springdata.repository.WardRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WardService {

    private final WardRepository wardRepository;


    public List<WardPatientCountDTO> findWardsAndPatientCount() {
        return wardRepository.findWardsAndPatientCount();
    }

    public List<WardDepartmentDTO> findWardsAndDepartments() {
        return wardRepository.findWardsAndDepartments();
    }

    public List<WardDirectorDTO> findWardsAndDirectors() {
        return wardRepository.findWardsAndDirectors();
    }
}
