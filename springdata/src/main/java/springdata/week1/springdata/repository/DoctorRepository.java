package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.entities.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d JOIN d.patients p WHERE p.id = :patientId")
    Doctor findDoctorByPatient(@Param("patientId") Long patientId);


    List<Doctor> findBySpeciality(String speciality);

}
