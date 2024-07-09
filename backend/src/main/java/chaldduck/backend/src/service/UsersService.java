package chaldduck.backend.src.service;

import chaldduck.backend.src.domain.Saju;
import chaldduck.backend.src.domain.Users;
import chaldduck.backend.src.dto.request.UsersInfoRequestDTO;
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
                .saju(Saju.builder()
                        .fiveHang("갑자")
                        .build())
                .build();
        return usersRepository.save(user);
    }
}
