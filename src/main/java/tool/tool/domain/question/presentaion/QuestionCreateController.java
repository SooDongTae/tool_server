package tool.tool.domain.question.presentaion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.question.presentaion.dto.request.QuestionCreateRequest;
import tool.tool.domain.question.service.QuestionCreateService;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionCreateController {

    private final QuestionCreateService questionCreateService;

    @PostMapping("/{id}")
    public void createQuestion(@PathVariable Long id, @RequestBody QuestionCreateRequest request) {
        questionCreateService.execute(id, request);
    }
}
