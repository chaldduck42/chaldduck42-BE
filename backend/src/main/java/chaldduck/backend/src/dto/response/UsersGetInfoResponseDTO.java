package chaldduck.backend.src.dto.response;

import chaldduck.backend.global.enums.Mbti;
import lombok.Getter;

import java.util.Date;

@Getter
public class UsersGetInfoResponseDTO {
    private Date birth;
    private String fiveHang;
    private String sajuDescription;
    private String sajuImg;
    private Mbti mbti;
    private String mbtiDescription;
    private String mbtiImg;


    public static UsersGetInfoResponseDTO of(Date birth, String fiveHang, String sajuDescription, String sajuImg, Mbti mbti, String mbtiDescription, String mbtiImg) {
        UsersGetInfoResponseDTO response = new UsersGetInfoResponseDTO();
        response.birth = birth;
        response.fiveHang = fiveHang;
        response.sajuDescription = sajuDescription;
        response.sajuImg = sajuImg;
        response.mbti = mbti;
        response.mbtiDescription = mbtiDescription;
        response.mbtiImg = mbtiImg;
        return response;
    }
}
