package tool.tool.domain.answer.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.answer.domain.repository.AnswerRepository;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.user.domain.User;

@Component
@RequiredArgsConstructor
public class AnswerFacade {

    private final AnswerRepository answerRepository;

    public Answer saveAnswer(Question question, User user, String content) {
        return answerRepository.save(Answer.builder()
                .content(content)
                .question(question)
                .user(user)
                .build());
    }
}
