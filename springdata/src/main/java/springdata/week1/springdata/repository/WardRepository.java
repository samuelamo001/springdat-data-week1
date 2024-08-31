package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import springdata.week1.springdata.dto.ward.WardDepartmentDTO;
import springdata.week1.springdata.dto.ward.WardDirectorDTO;
import springdata.week1.springdata.dto.ward.WardPatientCountDTO;
import springdata.week1.springdata.entities.Ward;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Long> {



    @Query("SELECT w.number AS wardNumber, COUNT(p.id) AS numberOfPatients " +
            "FROM Ward w LEFT JOIN w.patients p " +
            "GROUP BY w.number")
    List<WardPatientCountDTO> findWardsAndPatientCount();


    @Query("SELECT w.number AS wardNumber, w.numberOfBeds AS numberOfBeds, d.name AS departmentName " +
            "FROM Ward w JOIN w.department d")
    List<WardDepartmentDTO> findWardsAndDepartments();



    @Query("SELECT w.number AS wardNumber, CONCAT(e.firstName, ' ', e.surname) AS directorFullName " +
            "FROM Ward w JOIN w.department d JOIN d.director e")
    List<WardDirectorDTO> findWardsAndDirectors();


}
