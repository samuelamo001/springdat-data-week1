package springdata.week1.springdata.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.dto.doctor.DoctorPatientCountDTO;
import springdata.week1.springdata.entities.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {



    @Query(value = "SELECT e.id AS doctorId, " +
            "CONCAT(e.first_name, ' ', e.surname) AS doctorFullName, " +
            "d.speciality, COUNT(p.id) AS numberOfPatients " +
            "FROM doctors d " +
            "JOIN employee e ON d.id = e.id " +
            "JOIN patients p ON d.id = p.doctor_id " +
            "GROUP BY e.id, e.first_name, e.surname, d.speciality",
            nativeQuery = true)
    List<DoctorPatientCountDTO> findDoctorsAndPatients();





}
