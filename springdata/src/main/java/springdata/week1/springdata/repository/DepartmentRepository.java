package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.entities.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByBuilding(String building);

    @Query("SELECT d FROM Department d WHERE d.director.id = :doctorId")
    Department findDepartmentByDirector(@Param("doctorId") Long doctorId);

}
