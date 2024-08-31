package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    //Retrieve Patients and the Doctors Responsible for Them
    SELECT
    p.name AS patient_name,
    doc.id AS doctor_id,
    CONCAT(e.first_name, ' ', e.surname) AS doctor_full_name,
    doc.speciality
            FROM
    patients p
    JOIN
    doctors doc ON p.doctor_id = doc.id
            JOIN
    employee e ON doc.id = e.id
    ORDER BY
    p.name;


    //patients and their assigned ward
    SELECT p.name AS patient_name, w.number AS ward_number, w.number_of_beds
    FROM patients p
    JOIN wards w ON p.ward_id = w.id
    ORDER BY p.name;

    //Retrieve Patients and Their Address Information Along with Their Doctor's Speciality
    SELECT p.name AS patient_name, p.address, doc.speciality
    FROM patients p
    JOIN doctors doc ON p.doctor_id = doc.id;

    //patients and the nurse supervising their wards
    SELECT
    p.name AS patient_name,
    n.id AS nurse_id,
    CONCAT(e.first_name, ' ', e.surname) AS nurse_full_name,
    n.rotation
            FROM
    patients p
    JOIN
    wards w ON p.ward_id = w.id
            JOIN
    nurses n ON w.supervisor_id = n.id
            JOIN
    employee e ON n.id = e.id
    ORDER BY
    p.name;





}
