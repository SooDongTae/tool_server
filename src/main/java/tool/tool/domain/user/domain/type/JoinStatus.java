package tool.tool.domain.user.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JoinStatus {

    WAITING("waiting"),
    APPROVED("approved"),
    REJECTED("rejected");

    private final String status;
}
