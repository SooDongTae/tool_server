package tool.tool.domain.question.presentaion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.question.presentaion.dto.request.QuestionUpdateRequest;
import tool.tool.domain.question.service.QuestionUpdateService;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionUpdateController {

    private final QuestionUpdateService questionUpdateService;

    @PutMapping("/{id}")
    public void updateQuestion(@PathVariable Long id, @RequestBody QuestionUpdateRequest request) {
        questionUpdateService.execute(id, request);
    }
}
