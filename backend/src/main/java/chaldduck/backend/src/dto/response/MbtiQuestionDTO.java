package chaldduck.backend.src.dto.response;

import java.util.List;

public class MbtiQuestionDTO {

    private String question;
    private List<MbtiAnswerDTO> answers;

    public static MbtiQuestionDTO of(String question, List<MbtiAnswerDTO> answers) {
        MbtiQuestionDTO response = new MbtiQuestionDTO();
        response.question = question;
        response.answers = answers;
        return response;
    }
}
