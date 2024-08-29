package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entities.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
