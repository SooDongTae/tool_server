package tool.tool.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.facade.QuestionFacade;
import tool.tool.domain.question.presentaion.dto.request.QuestionUpdateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class QuestionUpdateService {

    private final QuestionFacade questionFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, QuestionUpdateRequest request) {
        Question question = questionFacade.findQuestionById(id);
        User currentUser = userFacade.getCurrentUser();
        User writer = question.getUser();
        questionFacade.checkUser(currentUser, writer);
        question.update(request);
    }

}
