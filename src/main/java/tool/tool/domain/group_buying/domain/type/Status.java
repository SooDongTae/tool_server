package tool.tool.domain.group_buying.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVATED("activated"),
    CANCELED("canceled"),
    EXPIRED("expired");

    private final String name;
}
