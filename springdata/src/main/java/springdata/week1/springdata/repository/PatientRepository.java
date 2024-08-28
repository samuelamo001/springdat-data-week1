package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.entities.Patient;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.ward.id = :wardId AND p.bedNumber = :bedNumber")
    Patient findPatientByWardAndBedNumber(@Param("wardId") Long wardId, @Param("bedNumber") Integer bedNumber);

    List<Patient> findByTreatingDoctorId(Long doctorId);
    Optional<Patient> findByWardIdAndBedNumber(Long wardId, Integer bedNumber);

}
