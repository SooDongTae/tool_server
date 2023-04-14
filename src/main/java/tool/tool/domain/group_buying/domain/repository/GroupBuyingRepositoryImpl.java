package tool.tool.domain.group_buying.domain.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.type.Category;
import tool.tool.domain.group_buying.domain.type.Status;

import java.util.List;

import static tool.tool.domain.group_buying.domain.QGroupBuying.groupBuying;
import static tool.tool.domain.user.domain.QLeader.leader;

@RequiredArgsConstructor
public class GroupBuyingRepositoryImpl implements GroupBuyingRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<GroupBuying> findGroupBuyingList(String category, int limit, int offset, String field, String sortWay) {
        return jpaQueryFactory
                .selectFrom(groupBuying)
                .join(groupBuying.leader, leader)
                .where(
                        groupBuying.status.eq(Status.ACTIVATED),
                        categoryEq(category)
                )
                .limit(limit)
                .offset(offset)
                .orderBy(
                        sortByField(field, sortWay)
                )
                .fetch();
    }

    private BooleanExpression categoryEq(String category) {
        if(category.equals("all")) {
            return null;
        }
        return groupBuying.category.eq(Category.valueOf(category));
    }

    private OrderSpecifier<?> sortByField(String field, String sortWay) {
        if(field.equals("create_at")) {
            if(sortWay.equals("desc")) {
                return new OrderSpecifier<>(Order.DESC, groupBuying.createdAt);
            }
            else if(sortWay.equals("asc")) {
                return new OrderSpecifier<>(Order.ASC, groupBuying.createdAt);
            }
        }
        return null;
    }
}
