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
        for (MbtiQuestion etQuestion : eiQuestions) {
            List<MbtiAnswer> eiAnswers = mbtiAnswerRepository.findAllByMbtiQuestion(etQuestion);
            List<MbtiAnswerDTO> mbtiAnswerDTOList = eiAnswers.stream().map(MbtiAnswerDTO::of).toList();
            MbtiQuestionDTO mbtiQuestionDTO = MbtiQuestionDTO.of(etQuestion.getQuestion(), mbtiAnswerDTOList);
            mbtiQuestionDTOList.add(mbtiQuestionDTO);
        }
        MbtiQuestionResponseDTO eiResponse = MbtiQuestionResponseDTO.of(Mbti.EI.getValue(), mbtiQuestionDTOList);
        mbtiQuestionResponseDTOList.add(eiResponse);

        // S&N
        List<MbtiQuestion> snQuestions = mbtiQuestionRepository.findAllByKind(Mbti.SN.getValue());
        for (MbtiQuestion snQuestion : snQuestions) {
            List<MbtiAnswer> snAnswers = mbtiAnswerRepository.findAllByMbtiQuestion(snQuestion);

        }

        // T&F
        List<MbtiQuestion> tfQuestions = mbtiQuestionRepository.findAllByKind(Mbti.TF.getValue());
        for (MbtiQuestion tfQuestion : tfQuestions) {
            List<MbtiAnswer> tfAnswers = mbtiAnswerRepository.findAllByMbtiQuestion(tfQuestion);
        }

        // J&P
        List<MbtiQuestion> jpQuestions = mbtiQuestionRepository.findAllByKind(Mbti.JP.getValue());
        for (MbtiQuestion jpQuestion : jpQuestions) {
            List<MbtiAnswer> jpAnswers = mbtiAnswerRepository.findAllByMbtiQuestion(jpQuestion);
        }

        return null;
    }
}
