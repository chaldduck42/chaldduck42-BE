package chaldduck.backend.src.service;

import chaldduck.backend.global.enums.Mbti;
import chaldduck.backend.src.domain.MbtiAnswer;
import chaldduck.backend.src.domain.MbtiQuestion;
import chaldduck.backend.src.dto.response.MbtiAnswerDTO;
import chaldduck.backend.src.dto.response.MbtiQuestionDTO;
import chaldduck.backend.src.dto.response.MbtiQuestionResponseDTO;
import chaldduck.backend.src.repository.MbtiAnswerRepository;
import chaldduck.backend.src.repository.MbtiQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MbtiService {

    private final MbtiQuestionRepository mbtiQuestionRepository;
    private final MbtiAnswerRepository mbtiAnswerRepository;

    public List<MbtiQuestionResponseDTO> getQuestions() {
        List<MbtiQuestionResponseDTO> mbtiQuestionResponseDTOList = new ArrayList<>();
        // E&I
        List<MbtiQuestion> eiQuestions = mbtiQuestionRepository.findAllByKind(Mbti.EI.getValue());
        List<MbtiQuestionDTO> mbtiQuestionDTOList = new ArrayList<>();
        getMBtiQuestionResponseDTO(eiQuestions, Mbti.EI, mbtiQuestionResponseDTOList);

        // S&N
        List<MbtiQuestion> snQuestions = mbtiQuestionRepository.findAllByKind(Mbti.SN.getValue());
        getMBtiQuestionResponseDTO(snQuestions, Mbti.SN, mbtiQuestionResponseDTOList);

        // T&F
        List<MbtiQuestion> tfQuestions = mbtiQuestionRepository.findAllByKind(Mbti.TF.getValue());
        getMBtiQuestionResponseDTO(tfQuestions, Mbti.TF, mbtiQuestionResponseDTOList);

        // J&P
        List<MbtiQuestion> jpQuestions = mbtiQuestionRepository.findAllByKind(Mbti.JP.getValue());
        getMBtiQuestionResponseDTO(jpQuestions, Mbti.JP, mbtiQuestionResponseDTOList);

        return mbtiQuestionResponseDTOList;
    }

    private void getMBtiQuestionResponseDTO(List<MbtiQuestion> mbtiQuestions, Mbti mbti, List<MbtiQuestionResponseDTO> mbtiQuestionResponseDTOList) {
        List<MbtiQuestionDTO> mbtiQuestionDTOList = new ArrayList<>();
        for (MbtiQuestion mbtiQuestion : mbtiQuestions) {
            List<MbtiAnswer> mbtiAnswerList = mbtiAnswerRepository.findAllByMbtiQuestion(mbtiQuestion);
            List<MbtiAnswerDTO> mbtiAnswerDTOList = mbtiAnswerList.stream().map(MbtiAnswerDTO::of).toList();
            MbtiQuestionDTO mbtiQuestionDTO = MbtiQuestionDTO.of(mbtiQuestion.getQuestion(), mbtiAnswerDTOList);
            mbtiQuestionDTOList.add(mbtiQuestionDTO);
        }
        MbtiQuestionResponseDTO mbtiQuestionResponseDTO = MbtiQuestionResponseDTO.of(mbti.getValue(), mbtiQuestionDTOList);
        mbtiQuestionResponseDTOList.add(mbtiQuestionResponseDTO);
    }
}
