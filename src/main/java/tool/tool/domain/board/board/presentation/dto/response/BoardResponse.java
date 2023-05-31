package tool.tool.domain.board.board.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.board.domain.Board;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResponse {
    private int grade;
    private int class_no;
    private int student_no;
    private String owner;
    private String title;
    private int views;
    private int likes;
    private LocalDateTime created_at;
    private String category;

    public static BoardResponse of(Board board) {
        return BoardResponse.builder()
                .grade(board.getUser().getStuNumber().getGrade())
                .class_no(board.getUser().getStuNumber().getBan())
                .student_no(board.getUser().getStuNumber().getNum())
                .owner(board.getUser().getName())
                .title(board.getTitle())
                .views(board.getViews())
                .likes(board.getTotalLikes())
                .created_at(board.getCreatedAt())
                .category(board.getCategory().getCategory())
                .build();
    }
}
