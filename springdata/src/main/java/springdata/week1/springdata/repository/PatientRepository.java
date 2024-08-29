package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
