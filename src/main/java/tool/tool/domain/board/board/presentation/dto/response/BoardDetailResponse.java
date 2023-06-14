package tool.tool.domain.board.board.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.board.domain.Board;

@Getter
@Builder
public class BoardDetailResponse{
    private int grade;
    private int class_no;
    private int student_no;
    private String owner;
    private String title;
    private int views;
    private int likes;
    private String myLike;
    private String content;
    private String category;

    public static BoardDetailResponse of(Board board, String myLike) {
        return BoardDetailResponse.builder()
                .grade(board.getUser().getStuNumber().getGrade())
                .class_no(board.getUser().getStuNumber().getBan())
                .student_no(board.getUser().getStuNumber().getNum())
                .owner(board.getUser().getName())
                .title(board.getTitle())
                .views(board.getViews())
                .likes(board.getTotalLikes())
                .myLike(myLike)
                .content(board.getContent())
                .category(board.getCategory().getCategory())
                .build();
    }
}
