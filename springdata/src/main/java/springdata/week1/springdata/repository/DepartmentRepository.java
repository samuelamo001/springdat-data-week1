package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.dto.DepartmentDirectorDTO;
import springdata.week1.springdata.entities.Department;
import springdata.week1.springdata.entities.Doctor;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "SELECT d.name as departmentName, d.code as departmentCode, e.first_name as directorFirstname, e.surname as directorSurname, doc.speciality as directorSpeciality " +
            "FROM department d " +
            "INNER JOIN employee e ON d.director_id = e.id " +
            "INNER JOIN doctors doc ON doc.id = e.id", nativeQuery = true)
    List<DepartmentDirectorDTO> findDepartmentDirectorsByDepartmentName();

    //Retrieve Departments and the Number of Wards in Each Department
    SELECT d.name AS department_name, COUNT(w.id) AS number_of_wards
    FROM department d
    LEFT JOIN wards w ON d.id = w.department_id
    GROUP BY d.name;

//Retrieve Departments and the Number of Nurses in Each Department
    SELECT d.name AS department_name, COUNT(n.id) AS number_of_nurses
    FROM department d
    LEFT JOIN nurses n ON d.id = n.department_id
    GROUP BY d.name;

   //Retrieve Department Name and Director's Full Name
    SELECT d.name AS department_name, CONCAT(e.first_name, ' ', e.surname) AS director_full_name
    FROM department d
    JOIN employee e ON d.director_id = e.id;

    //Retrieve Departments and the Average Salary of Nurses in Each Department
    SELECT d.name AS department_name, AVG(n.salary) AS average_nurse_salary
    FROM department d
    LEFT JOIN nurses n ON d.id = n.department_id
    GROUP BY d.name;











}
