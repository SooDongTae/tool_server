package tool.tool.domain.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface LeaderRepository extends JpaRepository<Leader, Long> {
    Optional<List<Leader>> findByUser(User user);
}
