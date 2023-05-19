package tool.tool.domain.group_buying.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.User;

import java.util.List;

public interface GroupBuyingRepositoryCustom {
    Page<GroupBuying> findGroupBuyingList(String category, String field, String sortWay, String title, String status, Pageable pageable);

}
