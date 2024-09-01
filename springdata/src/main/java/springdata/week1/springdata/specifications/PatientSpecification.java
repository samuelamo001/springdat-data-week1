package springdata.week1.springdata.specifications;

import org.springframework.data.jpa.domain.Specification;
import springdata.week1.springdata.entities.Patient;

public class PatientSpecification {

    public static Specification<Patient> hasDiagnosis(String diagnosis) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("diagnosis"), diagnosis);
    }

    public static Specification<Patient> treatedByDoctor(Long doctorId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("treatingDoctor").get("id"), doctorId);
    }

    public static Specification<Patient> isInWard(Long wardId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("ward").get("id"), wardId);
    }
}
