package chaldduck.backend.src.service;

import chaldduck.backend.src.domain.Saju;
import chaldduck.backend.src.domain.Users;
import chaldduck.backend.src.dto.request.UsersInfoRequestDTO;
import chaldduck.backend.src.dto.response.UsersGetInfoResponseDTO;
import chaldduck.backend.src.dto.response.UsersInfoByHashResponseDTO;
import chaldduck.backend.src.repository.SajuRepository;
import chaldduck.backend.src.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    // 가능한 문자들: 숫자, 대문자, 소문자
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // 보안 랜덤 객체
    private static final SecureRandom RANDOM = new SecureRandom();

    private final SajuRepository sajuRepository;

    public Users saveUser(UsersInfoRequestDTO usersInfoRequestDTO) {
        String sajuString = getSaju(usersInfoRequestDTO.getBirth());
        Saju saju = sajuRepository.findByFiveHang(sajuString);

        int length = 10;
        String randomString = generateRandomString(length);

        Users user = Users.builder()
                .nickname(usersInfoRequestDTO.getNickname())
                .birth(usersInfoRequestDTO.getBirth())
                .saju(saju)
                .mbti("mbti")
                .url(randomString)
                .sex(usersInfoRequestDTO.getSex())
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

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    private static String getSaju(String birth) {
        String yearString = birth.substring(4);
        int year = Integer.parseInt(yearString);
        String[] gan = {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
        String[] ji = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};

        // 간지 계산
        int ganIndex = (year - 4) % 10; // 4는 갑자 시작 기준
        int jiIndex = (year - 4) % 12;  // 4는 갑자 시작 기준

        return gan[ganIndex] + ji[jiIndex];
    }
}
