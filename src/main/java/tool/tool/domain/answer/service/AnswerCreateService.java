package tool.tool.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.answer.domain.repository.AnswerRepository;
import tool.tool.domain.answer.presentation.dto.request.AnswerCreateRequest;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.facade.QuestionFacade;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class AnswerCreateService {

    private final QuestionFacade questionFacade;
    private final UserFacade userFacade;
    private final AnswerRepository answerRepository;

    @Transactional
    public void execute(Long questionId, AnswerCreateRequest request) {
        Question question = questionFacade.findQuestionById(questionId);
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        answerRepository.save(request.toEntity(question, user));
    }

}
