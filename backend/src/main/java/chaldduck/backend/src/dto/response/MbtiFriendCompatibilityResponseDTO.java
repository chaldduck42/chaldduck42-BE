package chaldduck.backend.src.dto.response;

import lombok.Getter;

@Getter
public class MbtiFriendCompatibilityResponseDTO {

    private String mbtiDescription;
    private String mbtiImg;

    public static MbtiFriendCompatibilityResponseDTO of(String mbtiDescription, String mbtiImg) {
        MbtiFriendCompatibilityResponseDTO response = new MbtiFriendCompatibilityResponseDTO();
        response.mbtiDescription = mbtiDescription;
        response.mbtiImg = mbtiImg;
        return response;
    }
}
