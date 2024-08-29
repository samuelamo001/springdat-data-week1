package springdata.week1.springdata.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import springdata.week1.springdata.dto.DepartmentDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Doctor;
import springdata.week1.springdata.repository.DepartmentRepository;
import springdata.week1.springdata.repository.DoctorRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final PlatformTransactionManager transactionManager;

    public Department createDepartment(DepartmentDTO departmentDTO) {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("departmentCreationTransactionDefinition");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Doctor doctor = doctorRepository.findById(departmentDTO.getDirector())
                    .orElseThrow(() -> new EntityNotFoundException("Director not found"));

            Department department = Department.builder()
                    .name(departmentDTO.getName())
                    .code(departmentDTO.getCode())
                    .building(departmentDTO.getBuilding())
                    .director(doctor)
                    .build();


            departmentRepository.save(department);
            transactionManager.commit(status);
            return department;

        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;          }
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }




}
