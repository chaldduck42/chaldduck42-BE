package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.MbtiQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MbtiQuestionRepository extends JpaRepository<MbtiQuestion, Integer> {
}
