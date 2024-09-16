package springdata.week1.springdata.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entitie.Student;

@Registered
public interface StudentRepository extends JpaRepository<Student, Long> {
}
