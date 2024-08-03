package chaldduck.backend.src.controller;

import chaldduck.backend.src.dto.request.MbtiResultRequestDTO;
import chaldduck.backend.src.dto.response.MbtiFriendCompatibilityResponseDTO;
import chaldduck.backend.src.dto.response.MbtiQuestionResponseDTO;
import chaldduck.backend.src.dto.response.MbtiResultResponseDTO;
import chaldduck.backend.src.service.MbtiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mbti")
@RequiredArgsConstructor
public class MbtiController {

    private final MbtiService mbtiService;

    @GetMapping("/questions")
    public List<MbtiQuestionResponseDTO> getQuestions() {
        return mbtiService.getQuestions();
    }

    @PostMapping("/result")
    public MbtiResultResponseDTO getResult(@RequestBody MbtiResultRequestDTO mbtiResultRequestDTO) {
        return mbtiService.getResult(mbtiResultRequestDTO);
    }

    @GetMapping("/friend/compatibility")
    public MbtiFriendCompatibilityResponseDTO getFriendCompatibility(@RequestParam("myMbti") String myMbti, @RequestParam("friendMbti") String friendMbti) {
        return mbtiService.getFriendCompatibility(myMbti, friendMbti);
    }
}
