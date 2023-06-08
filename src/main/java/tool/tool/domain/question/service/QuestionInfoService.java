package tool.tool.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.facade.QuestionFacade;
import tool.tool.domain.question.presentaion.dto.response.QuestionListResponse;
import tool.tool.domain.question.presentaion.dto.response.QuestionResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionInfoService {

    private final GroupBuyingFacade groupBuyingFacade;
    private final QuestionFacade questionFacade;

    @Transactional
    public QuestionListResponse execute(Long groupBuyingId) {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(groupBuyingId);
        List<Question> questions = questionFacade.findQuestionsByGroupBuying(groupBuying);
        return QuestionListResponse.builder()
                .questionResponseList(questions.stream().map(QuestionResponse::of).collect(Collectors.toList()))
                .build();
    }
}
