package tool.tool.domain.answer.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.question.domain.Question;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
