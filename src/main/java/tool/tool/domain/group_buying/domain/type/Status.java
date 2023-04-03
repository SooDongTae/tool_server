package tool.tool.domain.group_buying.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVATED("ACTIVATED"),
    CANCELED("CANCELED"),
    EXPIRED("EXPIRED");

    private final String name;
}
