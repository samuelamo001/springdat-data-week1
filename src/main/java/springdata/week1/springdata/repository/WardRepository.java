package springdata.week1.springdata.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springdata.week1.springdata.dto.ward.WardDepartmentDTO;
import springdata.week1.springdata.dto.ward.WardDirectorDTO;
import springdata.week1.springdata.dto.ward.WardPatientCountDTO;
import springdata.week1.springdata.entities.Nurse;
import springdata.week1.springdata.entities.Ward;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Long>, JpaSpecificationExecutor<Ward> {



    @Query("SELECT w.number AS wardNumber, COUNT(p.id) AS numberOfPatients " +
            "FROM Ward w LEFT JOIN w.patients p " +
            "WHERE (:wardNumber IS NULL OR w.number = :wardNumber) " +
            "GROUP BY w.number")
    List<WardPatientCountDTO> findWardsAndPatientCount(@Param("wardNumber") String wardNumber);


    @Query("SELECT w.number AS wardNumber, w.numberOfBeds AS numberOfBeds, d.name AS departmentName " +
            "FROM Ward w JOIN w.department d" +
            " WHERE (:wardNumber IS NULL OR w.number = :wardNumber)")
    List<WardDepartmentDTO> findWardsAndDepartments(@Param("wardNumber") String wardNumber);



    @Query("SELECT w.number AS wardNumber, CONCAT(e.firstName, ' ', e.surname) AS directorFullName " +
            "FROM Ward w JOIN w.department d JOIN d.director e" +
            " WHERE (:wardNumber IS NULL OR w.number = :wardNumber)")
    List<WardDirectorDTO> findWardsAndDirectors(@Param("wardNumber") String wardNumber);


}
