package tool.tool.domain.board.like.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.board.domain.Board;
import tool.tool.domain.board.like.domain.Like;
import tool.tool.domain.board.like.domain.type.LikeKinds;

import java.util.stream.Collectors;

@Getter
@Builder
public class LikeResponse {
    private String myLike;
    private int totalLike;

    public static LikeResponse of(Like like, Board board) {
        return LikeResponse.builder()
                .myLike(like.getLikeKinds().getKind())
                .totalLike(board.getLikes().stream()
                        .filter(tempLike ->
                            tempLike.getLikeKinds().getKind().equals("LIKE")
                        ).toList()
                        .size())
                .build();
    }

}
