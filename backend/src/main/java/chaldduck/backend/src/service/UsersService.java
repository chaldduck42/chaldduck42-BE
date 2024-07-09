package chaldduck.backend.src.service;
import chaldduck.backend.global.enums.Mbti;

import chaldduck.backend.src.domain.Saju;
import chaldduck.backend.src.domain.Users;
import chaldduck.backend.src.dto.request.UsersInfoRequestDTO;
import chaldduck.backend.src.dto.response.UsersGetInfoResponseDTO;
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

    public UsersGetInfoResponseDTO getUserInfo(String nickname) {
        Users user = usersRepository.findByNickname(nickname);
        return UsersGetInfoResponseDTO.of(user.getBirth(),user.getSaju().getFiveHang(),user.getSaju().getDescription()
        ,user.getSaju().getImage(), Mbti.valueOf(user.getMbti()),"MBTI 설명 (enum이라 어찌 할지 모르겠음)","MBTI 이미지");
    }
}
