package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.Users;
import lombok.Getter;

@Getter
public class UsersInfoByHashResponseDTO {
    private String userId;
    private String nickname;
    private String birth;
    private String fiveHang;
    private String sajuDescription;
    private String sajuImg;
    private String mbti;



    public static UsersInfoByHashResponseDTO of(Users users) {
        UsersInfoByHashResponseDTO response = new UsersInfoByHashResponseDTO();
        response.userId = users.getId().toString();
        response.nickname = users.getNickname();
        response.birth = users.getBirth().toString();
        response.fiveHang = users.getSaju().getFiveHang();
        response.sajuDescription = users.getSaju().getDescription();
        response.sajuImg = users.getSaju().getImage();
        response.mbti = users.getMbti();
        return response;
    }
}
