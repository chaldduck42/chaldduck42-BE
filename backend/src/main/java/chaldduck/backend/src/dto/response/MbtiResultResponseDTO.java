package chaldduck.backend.src.dto.response;

import lombok.Getter;

@Getter
public class MbtiResultResponseDTO {

    private String mbti;

    public static MbtiResultResponseDTO of(String mbti) {
        MbtiResultResponseDTO response = new MbtiResultResponseDTO();
        response.mbti = mbti;
        return response;
    }
}
