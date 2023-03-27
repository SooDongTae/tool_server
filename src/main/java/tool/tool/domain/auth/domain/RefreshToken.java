package tool.tool.domain.auth.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash(value = "refreshToken", timeToLive = 1209600)
public class RefreshToken {
    @Id
    private String token;
    private String email;

    protected RefreshToken(){}

    @Builder
    public RefreshToken(String token, String email) {
        this.token = token;
        this.email = email;
    }
}
