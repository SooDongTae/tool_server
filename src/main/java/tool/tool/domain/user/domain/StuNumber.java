package tool.tool.domain.user.domain;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class StuNumber {
    private int grade;
    private int ban;
    private int num;
}
