package springdata.week1.springdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import springdata.week1.springdata.entities.Department;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, String> {

    @Query("{ 'director' : ?0 }")
    List<Department> findDepartmentsByDirector(String directorId);
}
