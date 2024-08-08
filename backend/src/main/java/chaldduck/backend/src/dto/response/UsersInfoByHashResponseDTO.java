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
    private String sex;



    public static UsersInfoByHashResponseDTO of(Users users) {
        UsersInfoByHashResponseDTO response = new UsersInfoByHashResponseDTO();
        response.userId = users.getId().toString();
        response.nickname = users.getNickname();
        response.birth = users.getBirth();
        response.fiveHang = users.getSaju().getFiveHang();
        response.sajuDescription = users.getSaju().getDescription();
        response.sajuImg = users.getSaju().getImage();
        response.mbti = users.getMbti();
        response.sex = users.getSex();
        return response;
    }
}
