package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.MbtiAnswer;
import chaldduck.backend.src.domain.MbtiQuestion;
import lombok.Getter;

import java.util.List;

@Getter
public class MbtiQuestionResponseDTO {

    private String type;
    private List<MbtiQuestionDTO> questions;

    public static MbtiQuestionResponseDTO of(String type, List<MbtiQuestionDTO> questions) {
        MbtiQuestionResponseDTO response = new MbtiQuestionResponseDTO();
        response.type = type;
        response.questions = questions;
        return response;
    }
}
