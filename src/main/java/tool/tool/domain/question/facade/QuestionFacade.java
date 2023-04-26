package tool.tool.domain.question.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.question.domain.Question;
import tool.tool.domain.question.domain.repository.QuestionRepository;
import tool.tool.domain.question.exception.QuestionNotFound;
import tool.tool.domain.question.presentaion.dto.request.QuestionCreateRequest;
import tool.tool.domain.user.domain.User;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionFacade {

    private final QuestionRepository questionRepository;

    @Transactional
    public Question saveQuestion(GroupBuying groupBuying, User user, QuestionCreateRequest request) {
        return questionRepository.save(
                Question.builder()
                        .content(request.getContent())
                        .isSecret(request.isSecret())
                        .groupBuying(groupBuying)
                        .user(user)
                        .build()
                );
    }

    @Transactional
    public Question findQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> QuestionNotFound.EXCEPTION);
    }

    @Transactional
    public List<Question> findQuestionsByGroupBuying(GroupBuying groupBuying) {
        return questionRepository.findByGroupBuying(groupBuying);
    }

}
