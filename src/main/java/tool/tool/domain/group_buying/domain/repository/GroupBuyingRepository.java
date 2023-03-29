package tool.tool.domain.group_buying.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.group_buying.domain.GroupBuying;

public interface GroupBuyingRepository extends JpaRepository<GroupBuying, Long> {
}
