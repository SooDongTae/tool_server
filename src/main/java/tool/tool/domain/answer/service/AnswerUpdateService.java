package tool.tool.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.answer.facade.AnswerFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class AnswerUpdateService {

    private final AnswerFacade answerFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, String content) {
        Answer answer = answerFacade.findAnswerById(id);
        User currentUser = userFacade.findUserById(userFacade.getCurrentUser().getId());
        userFacade.checkUser(currentUser, answer.getUser());
        answer.update(content);
    }

}
