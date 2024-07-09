package chaldduck.backend.src.controller;

import chaldduck.backend.src.dto.response.FriendResponseDTO;
import chaldduck.backend.src.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/list/{urlHash}")
    public List<FriendResponseDTO> getFriendList(@PathVariable String urlHash) {
        return friendService.getFriendList(urlHash);
    }
}
