package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdata.week1.springdata.dto.patient.PatientAddressDoctorSpecialityDTO;
import springdata.week1.springdata.dto.patient.PatientDoctorDTO;
import springdata.week1.springdata.dto.patient.PatientNurseDTO;
import springdata.week1.springdata.dto.patient.PatientWardDTO;
import springdata.week1.springdata.entities.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    @Query(value = "SELECT p.name AS patientName, " +
            "doc.id AS doctorId, " +
            "CONCAT(e.first_name, ' ', e.surname) AS doctorFullName, " +
            "doc.speciality " +
            "FROM patients p " +
            "JOIN doctors doc ON p.doctor_id = doc.id " +
            "JOIN employee e ON doc.id = e.id " +
            "ORDER BY p.name",
            nativeQuery = true)
    List<PatientDoctorDTO> findPatientsAndDoctors();


    @Query(value = "SELECT p.name AS patientName, " +
            "w.number AS wardNumber, w.number_of_beds " +
            "FROM patients p " +
            "JOIN wards w ON p.ward_id = w.id " +
            "ORDER BY p.name",
            nativeQuery = true)
    List<PatientWardDTO> findPatientsAndWards();

    @Query(value = "SELECT p.name AS patientName, " +
            "p.address, doc.speciality as doctorSpeciality " +
            "FROM patients p " +
            "JOIN doctors doc ON p.doctor_id = doc.id",
            nativeQuery = true)
    List<PatientAddressDoctorSpecialityDTO> findPatientsAndAddressAndDoctorSpeciality();

    @Query(value = "SELECT p.name AS patientName, " +
            "n.id AS nurseId, " +
            "CONCAT(e.first_name, ' ', e.surname) AS nurseFullName, " +
            "n.rotation " +
            "FROM patients p " +
            "JOIN wards w ON p.ward_id = w.id " +
            "JOIN nurses n ON w.supervisor_id = n.id " +
            "JOIN employee e ON n.id = e.id " +
            "ORDER BY p.name",
            nativeQuery = true)
    List<PatientNurseDTO> findPatientsAndNurses();
}
