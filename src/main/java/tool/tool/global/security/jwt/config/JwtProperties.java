package tool.tool.global.security.jwt.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties("jwt")
public class JwtProperties {
    private Long accessTime;
    private Long refreshTime;
    private String prefix;
    private String header;
    private String secretKey;
}
