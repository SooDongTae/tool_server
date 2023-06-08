package tool.tool.global.security.jwt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final Long accessTime;
    private final Long refreshTime;
    private final String prefix;
    private final String header;
    private final String secretKey;

    public JwtProperties(Long accessTime, Long refreshTime, String prefix, String header, String secretKey) {
        this.accessTime = accessTime;
        this.refreshTime = refreshTime;
        this.prefix = prefix;
        this.header = header;
        this.secretKey = secretKey;
    }
}
