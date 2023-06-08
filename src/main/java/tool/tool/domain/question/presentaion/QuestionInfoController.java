package tool.tool.domain.question.presentaion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.question.presentaion.dto.response.QuestionListResponse;
import tool.tool.domain.question.service.QuestionInfoService;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionInfoController {

    private final QuestionInfoService questionInfoService;

    @GetMapping("/{groupBuyingId}")
    public QuestionListResponse getQuestions(@PathVariable Long groupBuyingId) {
        return questionInfoService.execute(groupBuyingId);
    }
}
