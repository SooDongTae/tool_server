package tool.tool.domain.board.comment.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.board.comment.domain.Comment;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentResponse {
    private Long id;
    private String content;
    private int grade;
    private int class_no;
    private int student_no;
    private String name;
    private LocalDateTime lastModified;

    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .grade(comment.getUser().getStuNumber().getGrade())
                .class_no(comment.getUser().getStuNumber().getBan())
                .student_no(comment.getUser().getStuNumber().getNum())
                .name(comment.getUser().getName())
                .lastModified(comment.getModifiedAt())
                .build();
    }
}
