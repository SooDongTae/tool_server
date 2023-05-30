package tool.tool.domain.group_buying.domain.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.type.Category;
import tool.tool.domain.group_buying.domain.type.Status;

import java.util.List;

import static tool.tool.domain.group_buying.domain.QGroupBuying.groupBuying;
import static tool.tool.domain.user.domain.QParticipant.participant;
import static tool.tool.domain.user.domain.QUser.user;


@RequiredArgsConstructor
public class GroupBuyingRepositoryImpl implements GroupBuyingRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<GroupBuying> findGroupBuyingList(String category, String field, String sortWay, String title, String status, Pageable pageable) {
        List<GroupBuying> groupBuyingList = getGroupBuyingList(category, field, sortWay, title, status, pageable);
        Long count = getCount(category, field, sortWay, title, status);
        return new PageImpl<>(groupBuyingList, pageable, count);
    }


    public Long getCount(String category, String field, String sortWay, String title, String status) {
        return jpaQueryFactory
                .select(groupBuying.count())
                .from(groupBuying)
                .where(
                        categoryEq(category),
                        groupBuying.title.contains(title),
                        groupBuying.status.eq(Status.valueOf(status))
                )
                .orderBy(
                        sortByField(field, sortWay)
                )
                .fetchOne();
    }

    private List<GroupBuying> getGroupBuyingList(String category, String field, String sortWay, String title, String status, Pageable pageable) {
        return jpaQueryFactory
                .selectFrom(groupBuying)
                .join(groupBuying.user, user).fetchJoin()
                .leftJoin(groupBuying.participants, participant).fetchJoin()
                .where(
                        categoryEq(category),
                        groupBuying.title.contains(title),
                        groupBuying.status.eq(Status.valueOf(status))
                )
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
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
        else if(field.equals("views")) {
            if(sortWay.equals("desc")) {
                return new OrderSpecifier<>(Order.DESC, groupBuying.views);
            }
            else if(sortWay.equals("asc")) {
                return new OrderSpecifier<>(Order.ASC, groupBuying.views);
            }
        }
        return null;
    }
}
