package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.SajuCompatabilityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SajuCompatabilityDataRepository extends JpaRepository<SajuCompatabilityData, Integer> {
}
