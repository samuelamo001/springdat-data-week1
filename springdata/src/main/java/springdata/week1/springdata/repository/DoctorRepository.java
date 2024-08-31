package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.entities.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    //doctors and the patients they are responsible for
    SELECT
    e.id AS doctor_id,
    CONCAT(e.first_name, ' ', e.surname) AS doctor_full_name,
    d.speciality,
    COUNT(p.id) AS number_of_patients
    FROM
    doctors d
    JOIN
    employee e ON d.id = e.id
            JOIN
    patients p ON d.id = p.doctor_id
    GROUP BY
    e.id,
    e.first_name,
    e.surname,
    d.speciality;


    //Retrieve Doctors and the Wards Their Patients Are Assigned To
    SELECT
    e.id AS doctor_id,
    CONCAT(e.first_name, ' ', e.surname) AS doctor_full_name,
    d.speciality,
    w.number AS ward_number
            FROM
    doctors d
    JOIN
    employee e ON d.id = e.id
            JOIN
    patients p ON d.id = p.doctor_id
            JOIN
    wards w ON p.ward_id = w.id
    ORDER BY
    e.id, w.number;




}
