package tool.tool.domain.answer.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.answer.presentation.dto.request.AnswerCreateRequest;
import tool.tool.domain.answer.service.AnswerCreateService;

@RestController
@RequestMapping("/api/answer")
@RequiredArgsConstructor
public class AnswerCreateController {

    private final AnswerCreateService answerCreateService;

    @PostMapping("/{questionId}")
    public void createAnswer(@PathVariable Long questionId, @RequestBody AnswerCreateRequest request) {
        answerCreateService.execute(questionId, request);
    }
}
