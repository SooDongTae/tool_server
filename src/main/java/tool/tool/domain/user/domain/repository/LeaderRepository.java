package tool.tool.domain.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.user.domain.Leader;

public interface LeaderRepository extends JpaRepository<Leader, Long> {
}
