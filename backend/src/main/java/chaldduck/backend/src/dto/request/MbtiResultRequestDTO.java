package chaldduck.backend.src.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MbtiResultRequestDTO {

    private String nickname;

    private List<MbtiResult> mbtiResultList;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MbtiResult {
        private String type;

        private int score;
    }
}
