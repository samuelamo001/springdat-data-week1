package springdata.week1.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.entities.Ward;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {

    List<Ward> findByDepartmentId(Long departmentId);

}
