package tool.tool.domain.user.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.QGroupBuying;
import tool.tool.domain.user.domain.Participant;
import tool.tool.domain.user.domain.type.JoinStatus;

import static tool.tool.domain.user.domain.QUser.user;
import static tool.tool.domain.user.domain.QParticipant.participant;
import static tool.tool.domain.group_buying.domain.QGroupBuying.groupBuying;

import java.util.List;

@RequiredArgsConstructor
public class ParticipantRepositoryImpl implements ParticipantRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Participant> findByGroupBuying(GroupBuying groupBuying) {
        return jpaQueryFactory
                .selectFrom(participant)
                .join(participant.user, user).fetchJoin()
                .where(
                        participant.groupBuying.eq(groupBuying)
                )
                .fetch();
    }

    @Override
    public List<Participant> findIsWaitingInGroupBuying(List<GroupBuying> groupBuyingList) {
        return jpaQueryFactory
                .selectFrom(participant)
                .join(participant.user, user).fetchJoin()
                .join(participant.groupBuying, groupBuying).fetchJoin()
                .where(
                        participant.groupBuying.in(groupBuyingList),
                        participant.joinStatus.eq(JoinStatus.WAITING)
                )
                .fetch();

    }
}
