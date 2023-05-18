package tool.tool.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.user.domain.User;

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private int grade;
    private int classNo;
    private int stuNo;
    private String email;
    private String profileUrl;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .grade(user.getStuNumber().getGrade())
                .classNo(user.getStuNumber().getBan())
                .stuNo(user.getStuNumber().getNum())
                .email(user.getEmail())
                .profileUrl(user.getProfileUrl())
                .build();
    }
}
