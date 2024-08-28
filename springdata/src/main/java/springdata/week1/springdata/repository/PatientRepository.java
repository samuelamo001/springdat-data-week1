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

    @Query(value = "SELECT *  FROM patients as p WHERE p.ward_id = 1 AND p.bed_number = 1", nativeQuery = true)
    Patient findPatientByWardAndBedNumber(@Param("wardId") Long wardId, @Param("bedNumber") Integer bedNumber);

    List<Patient> findByTreatingDoctorId(Long doctorId);
    Optional<Patient> findByWardIdAndBedNumber(Long wardId, Integer bedNumber);

}
