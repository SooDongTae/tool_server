package tool.tool.domain.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
