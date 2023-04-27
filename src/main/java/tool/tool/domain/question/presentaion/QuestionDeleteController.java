package tool.tool.domain.question.presentaion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.question.service.QuestionDeleteService;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionDeleteController {

    private final QuestionDeleteService questionDeleteService;

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionDeleteService.execute(id);
    }
}
