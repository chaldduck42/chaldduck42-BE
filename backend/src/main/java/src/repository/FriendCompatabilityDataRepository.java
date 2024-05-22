package src.repository;

import chaldduck.backend.src.domain.FriendCompatabilityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendCompatabilityDataRepository extends JpaRepository<FriendCompatabilityData,Long> {

}
