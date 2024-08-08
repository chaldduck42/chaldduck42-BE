package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.FriendCompatibilityData;
import chaldduck.backend.src.domain.Users;
import lombok.Getter;

@Getter
public class FriendResponseDTO {

    private int friendId;
    private String nickname;
    private int totalScore;
    private String description;

    public static FriendResponseDTO of(Users friend, FriendCompatibilityData friendCompatibilityData) {
        FriendResponseDTO response = new FriendResponseDTO();
        response.friendId = friend.getId();
        response.nickname = friend.getNickname();
        response.totalScore = friendCompatibilityData.getTotalScore();
        response.description = friendCompatibilityData.getDescription();
        return response;
    }
}
