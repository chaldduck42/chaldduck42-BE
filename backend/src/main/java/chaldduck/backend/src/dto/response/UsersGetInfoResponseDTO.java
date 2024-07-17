package chaldduck.backend.src.dto.response;

import chaldduck.backend.global.enums.Mbti;
import chaldduck.backend.src.domain.Users;
import lombok.Getter;

import java.util.Date;

@Getter
public class UsersGetInfoResponseDTO {
    private String birth;
    private String fiveHang;
    private String sajuDescription;
    private String sajuImg;
    private String mbti;



    public static UsersGetInfoResponseDTO of(Users users) {
        UsersGetInfoResponseDTO response = new UsersGetInfoResponseDTO();
        response.birth = users.getBirth().toString();
        response.fiveHang = users.getSaju().getFiveHang();
        response.sajuDescription = users.getSaju().getDescription();
        response.sajuImg = users.getSaju().getImage();
        response.mbti = users.getMbti();
        return response;
    }
}
