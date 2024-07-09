package chaldduck.backend.src.service;
import chaldduck.backend.src.domain.Users;
import chaldduck.backend.src.dto.request.UsersInfoRequestDTO;
import chaldduck.backend.src.dto.response.UsersAllInfoResponseDTO;
import chaldduck.backend.src.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Users saveUser(UsersInfoRequestDTO usersInfoRequestDTO) {
        Users user = Users.builder()
                .nickname(usersInfoRequestDTO.getNickname())
                .birth(usersInfoRequestDTO.getBirth())
                //.saju()
                .build();
        return usersRepository.save(user);
    }

    public UsersAllInfoResponseDTO getUserInfo(String nickname) {
        Users user = usersRepository.findByNickname(nickname);
        return UsersAllInfoResponseDTO.of
    }
}
