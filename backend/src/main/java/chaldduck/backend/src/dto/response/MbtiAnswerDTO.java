package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.MbtiAnswer;
import lombok.Getter;

@Getter
public class MbtiAnswerDTO {

    private String option;
    private int score;

    public static MbtiAnswerDTO of(MbtiAnswer mbtiAnswer) {
        MbtiAnswerDTO response = new MbtiAnswerDTO();
        response.option = mbtiAnswer.getAnswer();
        response.score = mbtiAnswer.getScore();
        return response;
    }
}
