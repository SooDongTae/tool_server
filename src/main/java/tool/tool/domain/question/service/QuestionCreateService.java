package tool.tool.domain.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.facade.GroupBuyingFacade;
import tool.tool.domain.question.domain.repository.QuestionRepository;
import tool.tool.domain.question.presentaion.dto.request.QuestionCreateRequest;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class QuestionCreateService {

    private final QuestionRepository questionRepository;
    private final GroupBuyingFacade groupBuyingFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long id, QuestionCreateRequest request) {
        GroupBuying groupBuying = groupBuyingFacade.findGroupBuyingById(id);
        User user = userFacade.findUserById(userFacade.getCurrentUser().getId());
        questionRepository.save(request.toEntity(groupBuying, user));
    }
}
