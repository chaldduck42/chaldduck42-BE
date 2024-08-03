package chaldduck.backend.src.service;

import chaldduck.backend.src.domain.Saju;
import chaldduck.backend.src.domain.Users;
import chaldduck.backend.src.dto.request.UsersInfoRequestDTO;
import chaldduck.backend.src.dto.response.UsersGetInfoResponseDTO;
import chaldduck.backend.src.dto.response.UsersInfoByHashResponseDTO;
import chaldduck.backend.src.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Users saveUser(UsersInfoRequestDTO usersInfoRequestDTO) {
        // TODO 생년월일 기반으로 오행 정보 가져와서 넣어줘야함


        Users user = Users.builder()
                .nickname(usersInfoRequestDTO.getNickname())
                .birth(usersInfoRequestDTO.getBirth())
                .saju(Saju.builder()
                        .fiveHang("갑자")
                        .build())
                .mbti("mbti")
                .build();
        return usersRepository.save(user);
    }

    public UsersGetInfoResponseDTO getUserInfo(String nickname) {
        Users user = usersRepository.findByNickname(nickname);
        //Mbti mbti = user.mbti로 mbti 설명 가져오기
        return UsersGetInfoResponseDTO.of(user);
    }

    public UsersInfoByHashResponseDTO getUserInfoByHash(String urlHash){
        Users user = usersRepository.findByUrl(urlHash);
        return UsersInfoByHashResponseDTO.of(user);
    }

    @Transactional
    public void updateUsersMbtiByNickname(String nickname, String mbti) {
        Users users = usersRepository.findByNickname(nickname);
        users.updateMbti(mbti);
    }
}
