package tool.tool.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.answer.facade.AnswerFacade;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.facade.QuestionFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class AnswerCreateService {

    private final QuestionFacade questionFacade;
    private final UserFacade userFacade;
    private final AnswerFacade answerFacade;

    @Transactional
    public void execute(Long questionId, String content) {
        Question question = questionFacade.findQuestionById(questionId);
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        Answer answer = answerFacade.saveAnswer(question, user, content);
        answer.setQuestion(question);
        answer.setUser(user);
    }

}
