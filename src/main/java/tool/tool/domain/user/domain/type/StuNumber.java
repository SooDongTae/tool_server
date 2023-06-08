package tool.tool.domain.user.domain.type;


import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;

@Embeddable
@Getter
public class StuNumber {
    private int grade;
    private int ban;
    private int num;

    protected StuNumber() {}
    @Builder
    public StuNumber(int grade, int ban, int num) {
        this.grade = grade;
        this.ban = ban;
        this.num = num;
    }
}
