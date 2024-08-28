package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.entities.Nurse;

import java.util.List;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {

    @Query("SELECT n FROM Nurse n WHERE n.supervisedWard.id = :wardId")
    Nurse findNurseByWard(@Param("wardId") Long wardId);

    @Query("SELECT AVG(n.salary) FROM Nurse n WHERE n.department.id = :departmentId")
    Double findAverageSalaryByDepartment(@Param("departmentId") Long departmentId);

    List<Nurse> findByDepartmentId(Long departmentId);
    



}
