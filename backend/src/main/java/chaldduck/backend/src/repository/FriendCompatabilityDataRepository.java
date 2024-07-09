package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.FriendCompatibilityData;
import chaldduck.backend.src.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendCompatabilityDataRepository extends JpaRepository<FriendCompatibilityData,Long> {

    List<FriendCompatibilityData> findALlByLinkOwner(Users linkOwner);

}
