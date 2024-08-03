package chaldduck.backend.src.controller;

import chaldduck.backend.src.dto.request.UsersInfoRequestDTO;
import chaldduck.backend.src.dto.response.UsersGetInfoResponseDTO;
import chaldduck.backend.src.dto.response.UsersInfoByHashResponseDTO;
import chaldduck.backend.src.service.UsersService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/info")
    public void createUsers(@RequestBody UsersInfoRequestDTO usersInfoRequestDTO) {
        usersService.saveUser(usersInfoRequestDTO);
        //일단 dto 입력받아오고, 추가적으로 내가 그 정보로 갑자 만들어서 db에 저장
        //return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/info")
    public UsersGetInfoResponseDTO getUserInfo(@RequestBody String nickname) {
        return usersService.getUserInfo(nickname);

    }

    @GetMapping("/infoByHash/{urlHash}")
    public UsersInfoByHashResponseDTO getUserInfoByHash(@RequestBody String urlHash) {
        return usersService.getUserInfoByHash(urlHash);
    }
}
