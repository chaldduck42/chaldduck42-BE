package chaldduck.backend.src.service;

import chaldduck.backend.global.enums.Mbti;
import chaldduck.backend.src.domain.MbtiAnswer;
import chaldduck.backend.src.domain.MbtiCompatibilityData;
import chaldduck.backend.src.domain.MbtiQuestion;
import chaldduck.backend.src.dto.request.MbtiResultRequestDTO;
import chaldduck.backend.src.dto.response.*;
import chaldduck.backend.src.repository.MbtiAnswerRepository;
import chaldduck.backend.src.repository.MbtiCompatibilityDataRepository;
import chaldduck.backend.src.repository.MbtiQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MbtiService {

    private final MbtiQuestionRepository mbtiQuestionRepository;
    private final MbtiAnswerRepository mbtiAnswerRepository;
    private final MbtiCompatibilityDataRepository mbtiCompatibilityDataRepository;

    public List<MbtiQuestionResponseDTO> getQuestions() {
        List<MbtiQuestionResponseDTO> mbtiQuestionResponseDTOList = new ArrayList<>();
        // E&I
        List<MbtiQuestion> eiQuestions = mbtiQuestionRepository.findAllByKind(Mbti.EI.getValue());
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

    public MbtiResultResponseDTO getResult(List<MbtiResultRequestDTO> mbtiResultRequestDTOList) {
        StringBuilder mbti = new StringBuilder();
        for (MbtiResultRequestDTO mbtiResultRequestDTO : mbtiResultRequestDTOList) {
            String type = mbtiResultRequestDTO.getType();
            int score = mbtiResultRequestDTO.getScore();
            if (type.equals(Mbti.EI.getValue())) {
                if (score >= 0) mbti.append("E");
                else mbti.append("I");
            } else if (type.equals(Mbti.SN.getValue())) {
                if (score >= 0) mbti.append("S");
                else mbti.append("N");
            } else if (type.equals(Mbti.TF.getValue())) {
                if (score >= 0) mbti.append("T");
                else mbti.append("F");
            } else if (type.equals(Mbti.JP.getValue())) {
                if (score >= 0) mbti.append("J");
                else mbti.append("P");
            }
        }
        return MbtiResultResponseDTO.of(mbti.toString());
    }

    public MbtiFriendCompatibilityResponseDTO getFriendCompatibility(String myMbti, String friendMbti) {
        // 내 mbti와 친구 mbti 기준으로 궁합 정보(설명, 이미지) 가져오기
        MbtiCompatibilityData mbtiCompatibilityData = mbtiCompatibilityDataRepository.findByMbti1AndMbti2(myMbti, friendMbti);
        return MbtiFriendCompatibilityResponseDTO.of(mbtiCompatibilityData.getDescription(), mbtiCompatibilityData.getImage());
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
