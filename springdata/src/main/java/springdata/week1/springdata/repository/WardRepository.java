package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entities.Ward;

public interface WardRepository extends JpaRepository<Ward, Long> {
}
