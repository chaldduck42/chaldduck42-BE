package chaldduck.backend.src.repository;

import chaldduck.backend.src.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByNickname(String nickname);
}
