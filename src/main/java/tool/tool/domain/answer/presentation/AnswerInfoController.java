package tool.tool.domain.answer.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.answer.presentation.dto.response.AnswerListResponse;
import tool.tool.domain.answer.service.AnswerListService;

@RestController
@RequestMapping("/api/answer")
@RequiredArgsConstructor
public class AnswerInfoController {

    private final AnswerListService answerListService;

    @GetMapping("/{questionId}")
    public AnswerListResponse getAnswerList(@PathVariable Long questionId) {
        return answerListService.execute(questionId);
    }
}
