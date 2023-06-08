package tool.tool.domain.question.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.question.domain.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByGroupBuying(GroupBuying groupBuying);
}
