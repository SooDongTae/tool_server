package tool.tool.domain.answer.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.answer.service.AnswerDeleteService;

@RestController
@RequestMapping("/api/answer")
@RequiredArgsConstructor
public class AnswerDeleteController {

    private final AnswerDeleteService answerDeleteService;

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answerDeleteService.execute(id);
    }
}
