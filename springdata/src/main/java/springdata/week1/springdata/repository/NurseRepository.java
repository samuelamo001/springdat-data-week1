package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdata.week1.springdata.dto.nurse.NurseDepartmentDTO;
import springdata.week1.springdata.dto.nurse.NurseDirectorDTO;
import springdata.week1.springdata.dto.nurse.NurseWardDTO;
import springdata.week1.springdata.entities.Nurse;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Long> {


    @Query(value = "SELECT n.id AS nurseId, " +
            "CONCAT(e.first_name, ' ', e.surname) AS nurseFullName, " +
            "n.rotation, d.name AS departmentName " +
            "FROM nurses n " +
            "JOIN employee e ON n.id = e.id " +
            "JOIN department d ON n.department_id = d.id",
            nativeQuery = true)
    List<NurseDepartmentDTO> findNursesAndDepartments();


    @Query(value = "SELECT n.id AS nurseId, " +
            "CONCAT(e.first_name, ' ', e.surname) AS nurseFullName, " +
            "n.rotation, w.number AS wardNumber " +
            "FROM nurses n " +
            "JOIN employee e ON n.id = e.id " +
            "JOIN wards w ON n.id = w.supervisor_id " +
            "ORDER BY n.id, w.number",
            nativeQuery = true)
    List<NurseWardDTO> findNursesAndWards();


    @Query(value = "SELECT n.id AS nurseId, " +
            "CONCAT(ne.first_name, ' ', ne.surname) AS nurseFullName, " +
            "d.name AS departmentName, " +
            "CONCAT(e.first_name, ' ', e.surname) AS directorFullName " +
            "FROM nurses n " +
            "JOIN employee ne ON n.id = ne.id " +
            "JOIN department d ON n.department_id = d.id " +
            "JOIN employee e ON d.director_id = e.id",
            nativeQuery = true)
    List<NurseDirectorDTO> findNursesAndDirectors();

}
