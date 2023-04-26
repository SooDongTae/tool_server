package tool.tool.domain.question.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.domain.repository.QuestionRepository;
import tool.tool.domain.question.presentaion.dto.request.QuestionCreateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Component
@RequiredArgsConstructor
public class QuestionFacade {

    private final QuestionRepository questionRepository;

    @Transactional
    public Question saveQuestion(GroupBuying groupBuying, User user, QuestionCreateRequest request) {
        return questionRepository.save(
                Question.builder()
                        .content(request.getContent())
                        .groupBuying(groupBuying)
                        .user(user)
                        .build()
                );
    }

}
