package springdata.week1.springdata.specifications;

import org.springframework.data.jpa.domain.Specification;
import springdata.week1.springdata.entities.Department;

public class DepartmentSpecification {

    public static Specification<Department> hasBuilding(String building) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("building"), building);
    }

    public static Specification<Department> hasDirector(Long doctorId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("director").get("id"), doctorId);
    }

    public static Specification<Department> hasWardsGreaterThan(int count) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(
                criteriaBuilder.size(root.get("wards")), count);
    }

}
