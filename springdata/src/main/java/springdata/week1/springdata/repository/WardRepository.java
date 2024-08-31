package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entities.Ward;

public interface WardRepository extends JpaRepository<Ward, Long> {


    //wards and the number of patients in each ward
    SELECT w.number AS ward_number, COUNT(p.id) AS number_of_patients
    FROM wards w
    LEFT JOIN patients p ON w.id = p.ward_id
    GROUP BY w.number;


    //wards and the department they belong to
    SELECT w.number AS ward_number, w.number_of_beds, d.name AS department_name
    FROM wards w
    JOIN department d ON w.department_id = d.id;

    //Retrieve Wards and Their Director's Full Name in the Corresponding Department
    SELECT w.number AS ward_number, CONCAT(e.first_name, ' ', e.surname) AS director_full_name
    FROM wards w
    JOIN department d ON w.department_id = d.id
    JOIN employee e ON d.director_id = e.id;


}
