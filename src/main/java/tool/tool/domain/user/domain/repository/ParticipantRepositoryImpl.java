package tool.tool.domain.user.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.user.domain.Participant;

import static tool.tool.domain.user.domain.QUser.user;
import static tool.tool.domain.user.domain.QParticipant.participant;

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
}
