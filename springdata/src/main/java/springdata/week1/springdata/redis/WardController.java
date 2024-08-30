package springdata.week1.springdata.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springdata.week1.springdata.dto.WardDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/redis")
public class WardController {

    private final WardService redisService;

    @PostMapping
    public void createWard(@RequestBody WardDTO wardDTO){
        redisService.saveWard(wardDTO);
    }

    @GetMapping("/{wardId}")
    public WardDTO getWard(@PathVariable String wardId){
        return redisService.getWardById(wardId);
    }

    @GetMapping
    public List<Object> getAllWards(){
        return redisService.getAllWards();
    }

    @PutMapping("/{wardId}")
    public void updateWard(@PathVariable String wardId, @RequestBody WardDTO wardDTO){
        redisService.updateWard(wardId,wardDTO);
    }

    @DeleteMapping("/{wardId}")
    public void deleteWard(@PathVariable String wardId){
        redisService.deleteWard(wardId);
    }


    @GetMapping("/find-by-name")
    public List<WardDTO> findWardsByNameContains(@RequestParam String keyword) {
        return redisService.findWardsByNameContains(keyword);
    }


}
