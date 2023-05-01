package tool.tool.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.answer.facade.AnswerFacade;

@Service
@RequiredArgsConstructor
public class AnswerUpdateService {

    private final AnswerFacade answerFacade;

    @Transactional
    public void execute(Long id, String content) {
        Answer answer = answerFacade.findAnswerById(id);
        answer.update(content);
    }

}
