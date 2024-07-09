package chaldduck.backend.src.controller;

import chaldduck.backend.src.dto.response.SajuResultResponseDTO;
import chaldduck.backend.src.service.SajuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saju")
@RequiredArgsConstructor
public class SajuController {
    private final SajuService sajuService;

    @GetMapping("/result/{saju}")
    public SajuResultResponseDTO getSajuResult(@PathVariable String saju){
        return sajuService.getResult(saju);
    }


}
