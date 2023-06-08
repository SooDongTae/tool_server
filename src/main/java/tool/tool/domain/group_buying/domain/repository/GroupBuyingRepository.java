package tool.tool.domain.group_buying.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.User;

import java.util.List;


public interface GroupBuyingRepository extends JpaRepository<GroupBuying, Long>, GroupBuyingRepositoryCustom {
    List<GroupBuying> findByUser(User user);
}
