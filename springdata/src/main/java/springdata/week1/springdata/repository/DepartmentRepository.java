package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
