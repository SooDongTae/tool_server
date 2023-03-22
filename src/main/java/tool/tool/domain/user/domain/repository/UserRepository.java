package tool.tool.domain.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
