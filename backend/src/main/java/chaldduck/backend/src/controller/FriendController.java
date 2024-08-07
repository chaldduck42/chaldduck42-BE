package chaldduck.backend.src.controller;

import chaldduck.backend.src.dto.response.FriendDetailResponseDTO;
import chaldduck.backend.src.dto.response.FriendResponseDTO;
import chaldduck.backend.src.dto.request.SajuCompabilityRequestDTO;
import chaldduck.backend.src.dto.response.SajuCompabilityResponseDTO;
import chaldduck.backend.src.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/list/{urlHash}")
    public List<FriendResponseDTO> getFriendList(@PathVariable String urlHash) {
        return friendService.getFriendList(urlHash);
    }

    @GetMapping("/detail/{urlHash}/{friendId}")
    public FriendDetailResponseDTO getFriendDetail(@PathVariable String urlHash, @PathVariable int friendId) {
        return friendService.getFriendDetail(urlHash, friendId);
    }

    @GetMapping("/saju/compability")
    public SajuCompabilityResponseDTO getSajuCompability(@RequestBody SajuCompabilityRequestDTO sajuCompabilityRequestDTO){
        return friendService.getSajuCompability(sajuCompabilityRequestDTO);
    }

}
