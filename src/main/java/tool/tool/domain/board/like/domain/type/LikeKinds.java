package tool.tool.domain.board.like.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LikeKinds {

    LIKE("like"),
    NONE("none");

    private final String kind;
}
