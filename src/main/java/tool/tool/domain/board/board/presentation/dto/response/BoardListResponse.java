package tool.tool.domain.board.board.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import tool.tool.domain.board.board.domain.Board;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class BoardListResponse {
    private int maxPage;
    private List<BoardResponse> boardResponseList;

    public static BoardListResponse of(Page<Board> boards) {
        return BoardListResponse.builder()
                .maxPage(boards.getTotalPages())
                .boardResponseList(boards.stream().map(BoardResponse::of).collect(Collectors.toList()))
                .build();
    }
}
