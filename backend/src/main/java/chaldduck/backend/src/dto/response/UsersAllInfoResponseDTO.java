package chaldduck.backend.src.dto.response;

import chaldduck.backend.global.enums.Mbti;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
public class UsersAllInfoResponseDTO {
    private Date birth;
    private String fiveHang;
    private String sajuDescription;
    private String sajuImg;
    private Mbti mbti;
    private String mbtiDescription;
    private String mbtiImg;


    public static UsersAllInfoResponseDTO of(Date birth, String fiveHang, String sajuDescription, String sajuImg, Mbti mbti, String mbtiDescription, String mbtiImg) {
        UsersAllInfoResponseDTO response = new UsersAllInfoResponseDTO();
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
