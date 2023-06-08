package tool.tool.domain.answer.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.answer.domain.repository.AnswerRepository;
import tool.tool.domain.answer.exception.AnswerNotFound;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.user.domain.User;

@Component
@RequiredArgsConstructor
public class AnswerFacade {

    private final AnswerRepository answerRepository;

    @Transactional
    public Answer findAnswerById(Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> AnswerNotFound.EXCEPTION);
    }

    @Transactional
    public void deleteAnswer(Answer answer) {
        answerRepository.delete(answer);
    }
}
