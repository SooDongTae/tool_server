package tool.tool.domain.board.like.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.like.domain.Like;

@Getter
@Builder
public class LikeResponse {
    private String myLike;
    private int totalLike;

    public static LikeResponse of(Like like) {
        return LikeResponse.builder()
                .myLike(like.getLikeKinds().getKind())
                .totalLike(like.getBoard().getTotalLikes())
                .build();
    }

}
