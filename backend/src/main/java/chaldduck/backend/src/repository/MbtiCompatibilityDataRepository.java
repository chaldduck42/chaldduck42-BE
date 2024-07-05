package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.MbtiCompatibilityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MbtiCompatibilityDataRepository extends JpaRepository<MbtiCompatibilityData,Long> {

    MbtiCompatibilityData findByMbti1AndMbti2(String mbti1, String mbti2);
}
