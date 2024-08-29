package springdata.week1.springdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springdata.week1.springdata.entities.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
