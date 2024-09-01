package springdata.week1.springdata.specifications;

import org.springframework.data.jpa.domain.Specification;
import springdata.week1.springdata.entities.Ward;

public class WardSpecification {

    public static Specification<Ward> hasNumber(String number) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("number"), number);
    }

    public static Specification<Ward> hasBedsGreaterThan(int count) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("numberOfBeds"), count);
    }

    public static Specification<Ward> belongsToDepartment(Long departmentId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("department").get("id"), departmentId);
    }
}
