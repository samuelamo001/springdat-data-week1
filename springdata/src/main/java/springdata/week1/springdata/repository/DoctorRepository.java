package springdata.week1.springdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.entities.Doctor;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
