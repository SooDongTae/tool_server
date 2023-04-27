package tool.tool.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.exception.DifferentUserException;
import tool.tool.domain.question.facade.QuestionFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class QuestionDeleteService {

    private final QuestionFacade questionFacade;
    private final UserFacade userFacade;

    public void execute(Long id) {
        Question question = questionFacade.findQuestionById(id);
        User currentUser = userFacade.getCurrentUser();
        User writer = question.getUser();
        checkUser(currentUser, writer);
        questionFacade.deleteQuestion(question);
    }

    private void checkUser(User currentUser, User writer) {
        if(!currentUser.getId().equals(writer.getId())) {
            throw DifferentUserException.EXCEPTION;
        }
    }

}
