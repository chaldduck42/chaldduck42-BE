package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.FriendCompatibilityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendCompatabilityDataRepository extends JpaRepository<FriendCompatibilityData,Long> {

}
