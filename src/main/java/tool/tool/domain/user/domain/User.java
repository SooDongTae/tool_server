package tool.tool.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Embedded
    private StuNumber stuNumber;

    @Column(name = "user_email")
    private String email;

    protected User() {}

    @Builder
    public User(Long id, String name, StuNumber stuNumber, String email) {
        this.id = id;
        this.name = name;
        this.stuNumber = stuNumber;
        this.email = email;
    }
}
