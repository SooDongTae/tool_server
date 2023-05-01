package tool.tool.domain.answer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.answer.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
