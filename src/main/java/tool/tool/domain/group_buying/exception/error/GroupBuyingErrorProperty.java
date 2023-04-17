package tool.tool.domain.group_buying.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@AllArgsConstructor
public enum GroupBuyingErrorProperty implements ErrorProperty {
    GROUP_BUYING_NOT_FOUND(404, "해당 공구가 없습니다."),
    PEOPLE_MAX(500, "이미 완성된 공구입니다.");

    private final int status;
    private final String message;
}
