package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.MbtiAnswer;
import chaldduck.backend.src.domain.MbtiQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MbtiAnswerRepository extends JpaRepository<MbtiAnswer, Long> {

    List<MbtiAnswer> findAllByMbtiQuestion(MbtiQuestion mbtiQuestion);
}
