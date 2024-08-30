package springdata.week1.springdata.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import springdata.week1.springdata.dto.WardDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WardService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "Ward";

    public void saveWard(WardDTO wardDTO) {

        if (wardDTO == null || wardDTO.getId() == null) {
            throw new IllegalArgumentException("Ward data and ID must not be null");
        }
        redisTemplate.opsForHash().put(KEY, wardDTO.getId(), wardDTO);
    }

    public WardDTO getWardById(String wardId){
        return (WardDTO) redisTemplate.opsForHash().get(KEY, wardId);
    }

    public List<Object> getAllWards(){
        return redisTemplate.opsForHash().values(KEY);
    }

    public void updateWard(String id, WardDTO wardDTO){
        redisTemplate.opsForHash().put(KEY, id, wardDTO);
    }

    public void deleteWard(String wardId){
        redisTemplate.opsForHash().delete(KEY, wardId);
    }


    public List<WardDTO> findWardsByNameContains(String keyword) {
        return redisTemplate.opsForHash().values(KEY).stream()
                .map(obj -> (WardDTO) obj)
                .filter(ward -> ward.getName() != null && ward.getName().contains(keyword))
                .collect(Collectors.toList());
    }


}
