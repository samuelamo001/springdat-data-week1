package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.week1.springdata.entities.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Long> {


    //nurse and department they are assigned to
    SELECT
    n.id AS nurse_id,
    CONCAT(e.first_name, ' ', e.surname) AS nurse_full_name,
    n.rotation,
    d.name AS department_name
            FROM
    nurses n
    JOIN
    employee e ON n.id = e.id
            JOIN
    department d ON n.department_id = d.id;


    //Retrieve Nurses and the Wards They Supervise
    SELECT
    n.id AS nurse_id,
    CONCAT(e.first_name, ' ', e.surname) AS nurse_full_name,
    n.rotation,
    w.number AS ward_number
            FROM
    nurses n
    JOIN
    employee e ON n.id = e.id
            JOIN
    wards w ON n.id = w.supervisor_id
    ORDER BY
    n.id, w.number;


    //Retrieve Nurses and Their Corresponding Department Directors
    SELECT
    n.id AS nurse_id,
    CONCAT(ne.first_name, ' ', ne.surname) AS nurse_full_name,
    d.name AS department_name,
    CONCAT(e.first_name, ' ', e.surname) AS director_full_name
    FROM
    nurses n
    JOIN
    employee ne ON n.id = ne.id
            JOIN
    department d ON n.department_id = d.id
            JOIN
    employee e ON d.director_id = e.id;




}
