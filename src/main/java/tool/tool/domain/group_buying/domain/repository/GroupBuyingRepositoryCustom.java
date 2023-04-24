package tool.tool.domain.group_buying.domain.repository;

import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.Participant;

import java.util.List;

public interface GroupBuyingRepositoryCustom {
    List<GroupBuying> findGroupBuyingList(String category, int limit, int offset, String field, String sortWay, String title, String status);
}
