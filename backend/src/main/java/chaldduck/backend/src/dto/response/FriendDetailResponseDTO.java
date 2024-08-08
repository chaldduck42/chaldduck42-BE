package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.MbtiCompatibilityData;
import chaldduck.backend.src.domain.SajuCompatibilityData;
import chaldduck.backend.src.domain.Users;
import lombok.Getter;

@Getter
public class FriendDetailResponseDTO {

    private String userId;
    private String nickname;
    private String birth;
    private String sajuDescription;
    private String sajuImg;
    private String mbtiDescription;
    private String mbtiImg;

    public static FriendDetailResponseDTO of(Users friend, SajuCompatibilityData sajuCompatibilityData, MbtiCompatibilityData mbtiCompatibilityData) {
        FriendDetailResponseDTO response = new FriendDetailResponseDTO();
        response.userId = friend.getId().toString();
        response.nickname = friend.getNickname();
        response.birth = friend.getBirth();
        response.sajuDescription = sajuCompatibilityData.getDescription();
        response.sajuImg = sajuCompatibilityData.getImage();
        response.mbtiDescription = mbtiCompatibilityData.getDescription();
        response.mbtiImg = mbtiCompatibilityData.getImage();
        return response;
    }
}
