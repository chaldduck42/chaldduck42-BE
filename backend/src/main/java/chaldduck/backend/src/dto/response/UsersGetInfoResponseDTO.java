package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.Users;
import lombok.Getter;

@Getter
public class UsersGetInfoResponseDTO {
    private String birth;
    private String fiveHang;
    private String sajuDescription;
    private String sajuImg;
    private String mbti;
    private String sex;



    public static UsersGetInfoResponseDTO of(Users users) {
        UsersGetInfoResponseDTO response = new UsersGetInfoResponseDTO();
        response.birth = users.getBirth();
        response.fiveHang = users.getSaju().getFiveHang();
        response.sajuDescription = users.getSaju().getDescription();
        response.sajuImg = users.getSaju().getImage();
        response.mbti = users.getMbti();
        response.sex = users.getSex();
        return response;
    }
}
