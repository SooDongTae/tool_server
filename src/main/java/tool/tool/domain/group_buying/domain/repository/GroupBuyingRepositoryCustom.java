package tool.tool.domain.group_buying.domain.repository;

import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.Leader;

import java.util.List;

public interface GroupBuyingRepositoryCustom {
    List<GroupBuying> findGroupBuyingList(String category, int limit, int offset, String field, String sortWay, String title, String status);
    List<GroupBuying> findGroupBuyingListByLeader(List<Leader> leaders);
}
