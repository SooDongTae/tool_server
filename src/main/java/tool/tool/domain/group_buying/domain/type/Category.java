package tool.tool.domain.group_buying.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    CATEGORY_PRODUCT("PRODUCT"),
    CATEGORY_FOOD("FOOD"),
    CATEGORY_CLOTHES("CLOTHES"),
    CATEGORY_ETC("ETC");

    private final String category;
}
