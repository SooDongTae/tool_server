package tool.tool.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.facade.QuestionFacade;
import tool.tool.domain.question.presentaion.dto.request.QuestionUpdateRequest;

@Service
@RequiredArgsConstructor
public class QuestionUpdateService {

    private final QuestionFacade questionFacade;

    @Transactional
    public void execute(Long id, QuestionUpdateRequest request) {
        Question question = questionFacade.findQuestionById(id);
        question.update(request);
    }

}
