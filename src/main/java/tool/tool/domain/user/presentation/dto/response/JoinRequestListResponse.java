package tool.tool.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class JoinRequestListResponse {
    List<JoinRequestResponse> joinRequestResponses;
}
