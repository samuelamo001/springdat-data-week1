package springdata.week1.springdata.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.NurseDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Nurse;
import springdata.week1.springdata.entities.Ward;
import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.NurseRepository;
import springdata.week1.springdata.repository.WardRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NurseService {

    private final NurseRepository nurseRepository;
    private final DepartmentRepository departmentRepository;
    private final WardRepository wardRepository;


    @Transactional
    public Nurse createNurse(NurseDTO nurseDTO) {
        Department department = departmentRepository.findById(nurseDTO.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        Nurse nurse = Nurse.builder()
                .surname(nurseDTO.getSurname())
                .firstName(nurseDTO.getFirstName())
                .address(nurseDTO.getAddress())
                .telephoneNumber(nurseDTO.getTelephoneNumber())
                .rotation(nurseDTO.getRotation())
                .salary(nurseDTO.getSalary())
                .department(department)
                .build();

        return nurseRepository.save(nurse);
    }

    public Nurse updateNurse(Long id, NurseDTO nurseDTO) {

        Nurse nurse = nurseRepository.findById(id).orElseThrow(() -> new RuntimeException("Nurse not found"));
        nurse.setSurname(nurseDTO.getSurname());
        nurse.setFirstName(nurseDTO.getFirstName());
        nurse.setAddress(nurseDTO.getAddress());
        nurse.setTelephoneNumber(nurseDTO.getTelephoneNumber());
        nurse.setRotation(nurseDTO.getRotation());
        nurse.setSalary(nurseDTO.getSalary());

        return nurseRepository.save(nurse);
    }

  public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
  }
}
