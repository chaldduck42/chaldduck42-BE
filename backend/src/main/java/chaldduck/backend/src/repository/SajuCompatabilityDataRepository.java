package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.SajuCompatibilityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SajuCompatabilityDataRepository extends JpaRepository<SajuCompatibilityData, Integer> {
}
