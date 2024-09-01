package springdata.week1.springdata.specifications;

import org.springframework.data.jpa.domain.Specification;
import springdata.week1.springdata.entities.Nurse;

public class NurseSpecification {

    public static Specification<Nurse> worksInDepartment(Long departmentId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("department").get("id"), departmentId);
    }

    public static Specification<Nurse> hasSalaryGreaterThan(Double salary) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salary"), salary);
    }

    public static Specification<Nurse> isSupervisor() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("supervisedWard"));
    }
}
