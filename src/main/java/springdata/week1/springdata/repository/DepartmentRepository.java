package springdata.week1.springdata.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.dto.department.DepartmentAverageNurseSalaryDTO;
import springdata.week1.springdata.dto.department.DepartmentDirectorDTO;
import springdata.week1.springdata.dto.department.DepartmentNurseCountDTO;
import springdata.week1.springdata.dto.department.DepartmentWardCountDTO;
import springdata.week1.springdata.entities.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {

    @Query(value = "SELECT d.name as departmentName, d.code as departmentCode, e.first_name as directorFirstname, e.surname as directorSurname, doc.speciality as directorSpeciality " +
            "FROM department d " +
            "INNER JOIN employee e ON d.director_id = e.id " +
            "INNER JOIN doctors doc ON doc.id = e.id", nativeQuery = true)
   /* @Query("SELECT new springdata.week1.springdata.dto.department.DepartmentDirectorDTO(d.name, d.code, e.firstName, e.surname, doc.speciality) " +
        "FROM Department d " +
        "INNER JOIN Employee e ON d.director.id = e.id " +
        "INNER JOIN Doctor doc ON doc.id = e.id")*/
    List<DepartmentDirectorDTO> findDepartmentDirectorsByDepartmentName();

    @Query(value = "SELECT d.name AS departmentName, COUNT(w.id) AS numberOfWards " +
            "FROM department d " +
            "LEFT JOIN wards w ON d.id = w.department_id " +
            "GROUP BY d.name", nativeQuery = true)
    List<DepartmentWardCountDTO> findDepartmentsAndWardCount();


    @Query(value = "SELECT d.name AS departmentName, COUNT(n.id) AS numberOfNurses " +
            "FROM department d " +
            "LEFT JOIN nurses n ON d.id = n.department_id " +
            "GROUP BY d.name", nativeQuery = true)
    List<DepartmentNurseCountDTO> findDepartmentsAndNurseCount();



    @Query(value = "SELECT d.name AS departmentName, AVG(n.salary) AS averageNurseSalary " +
            "FROM department d " +
            "LEFT JOIN nurses n ON d.id = n.department_id " +
            "GROUP BY d.name", nativeQuery = true)
        List<DepartmentAverageNurseSalaryDTO> findDepartmentsAndAverageNurseSalary();


}
