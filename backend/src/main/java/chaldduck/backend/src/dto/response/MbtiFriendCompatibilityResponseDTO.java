package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.MbtiCompatibilityData;
import lombok.Getter;

@Getter
public class MbtiFriendCompatibilityResponseDTO {

    private String mbtiDescription;
    private String mbtiImg;
    private int mbtiScore;

    public static MbtiFriendCompatibilityResponseDTO of(MbtiCompatibilityData mbtiCompatibilityData) {
        MbtiFriendCompatibilityResponseDTO response = new MbtiFriendCompatibilityResponseDTO();
        response.mbtiDescription = mbtiCompatibilityData.getDescription();
        response.mbtiImg = mbtiCompatibilityData.getImage();
        response.mbtiScore = mbtiCompatibilityData.getScore();
        return response;
    }
}
