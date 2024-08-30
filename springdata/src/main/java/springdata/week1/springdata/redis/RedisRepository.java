package springdata.week1.springdata.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springdata.week1.springdata.dto.WardDTO;

@Repository
public interface RedisRepository extends CrudRepository<WardDTO, String> {

}
