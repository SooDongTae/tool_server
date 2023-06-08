package tool.tool.domain.question.presentaion.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class QuestionListResponse {
    private List<QuestionResponse> questionResponseList;
}
