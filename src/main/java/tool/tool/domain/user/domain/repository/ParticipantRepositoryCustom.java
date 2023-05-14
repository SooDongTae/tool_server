package tool.tool.domain.user.domain.repository;

import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.Participant;

import java.util.List;

public interface ParticipantRepositoryCustom {
    List<Participant> findByGroupBuying(GroupBuying groupBuying);
}
