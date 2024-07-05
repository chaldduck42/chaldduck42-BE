package chaldduck.backend.src.controller;

import chaldduck.backend.src.domain.Users;
import chaldduck.backend.src.dto.request.UsersInfoRequestDTO;
import chaldduck.backend.src.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private UsersService usersService;

    @PostMapping("/info")
    public void createUsers(@RequestBody UsersInfoRequestDTO usersInfoRequestDTO) {
        usersService.saveUser(usersInfoRequestDTO);
        //일단 dto 입력받아오고, 추가적으로 내가 그 정보로 갑자 만들어서 db에 저장
        //return new ResponseEntity<>(HttpStatus.OK);

    }
}
