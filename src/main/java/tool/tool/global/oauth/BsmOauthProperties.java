package tool.tool.global.oauth;

import leehj050211.bsmOauth.BsmOauth;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties("bsm")
public class BsmOauthProperties {
    private String client_id;
    private String secret_key;

    @Bean("bsmOauth")
    public BsmOauth bsmOauth() {
        return new BsmOauth(client_id, secret_key);
    }

}
