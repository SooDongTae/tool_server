package tool.tool.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Embedded
    private StuNumber stuNumber;

    @Column(name = "oauth_code")
    private String oauthCode;

    protected User() {}

    @Builder
    public User(Long id, String name, StuNumber stuNumber, String oauthCode) {
        this.id = id;
        this.name = name;
        this.stuNumber = stuNumber;
        this.oauthCode = oauthCode;
    }
}
