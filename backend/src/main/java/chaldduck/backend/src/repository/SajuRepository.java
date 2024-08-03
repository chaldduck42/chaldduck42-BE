package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.Saju;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SajuRepository extends JpaRepository<Saju, Integer> {
    Saju findByFiveHang(String fiveHang);
}
