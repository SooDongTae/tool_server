package tool.tool.domain.answer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.answer.domain.Answer;
import tool.tool.domain.answer.domain.repository.AnswerRepository;
import tool.tool.domain.answer.facade.AnswerFacade;
import tool.tool.domain.answer.presentation.dto.response.AnswerListResponse;
import tool.tool.domain.answer.presentation.dto.response.AnswerResponse;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.facade.QuestionFacade;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerListService {

    private final QuestionFacade questionFacade;
    private final AnswerRepository answerRepository;

    @Transactional
    public AnswerListResponse execute(Long questionId) {
        Question question = questionFacade.findQuestionById(questionId);
        List<Answer> answerList = answerRepository.findByQuestion(question);
        return AnswerListResponse.builder()
                .answerResponseList(answerList.stream().map(AnswerResponse::of).collect(Collectors.toList()))
                .build();
    }
}
