package tool.tool.domain.answer.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.answer.domain.Answer;

import java.util.List;

@Getter
@Builder
public class AnswerListResponse {
    private List<AnswerResponse> answerResponseList;
}
