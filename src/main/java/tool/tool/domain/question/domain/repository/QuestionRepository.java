package tool.tool.domain.question.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.question.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
