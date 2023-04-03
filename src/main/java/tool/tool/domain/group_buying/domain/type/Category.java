package tool.tool.domain.group_buying.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    PRODUCT("PRODUCT"),
    FOOD("FOOD"),
    CLOTHES("CLOTHES"),
    ETC("ETC");

    private final String category;
}
