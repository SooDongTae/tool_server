package tool.tool.domain.group_buying.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    PRODUCT("product"),
    FOOD("food"),
    CLOTHES("clothes"),
    ETC("etc");

    private final String category;
}
