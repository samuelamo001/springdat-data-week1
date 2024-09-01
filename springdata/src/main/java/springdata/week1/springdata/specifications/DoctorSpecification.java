package springdata.week1.springdata.specifications;

import org.springframework.data.jpa.domain.Specification;
import springdata.week1.springdata.entities.Doctor;

public class DoctorSpecification {

    public static Specification<Doctor> hasSpeciality(String speciality) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("speciality"), speciality);
    }

    public static Specification<Doctor> hasPatientsGreaterThan(Integer count) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(
                criteriaBuilder.size(root.get("patients")), count);
    }

    public static Specification<Doctor> worksInDepartment(Long departmentId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("directedDepartment").get("id"), departmentId);
    }
}
