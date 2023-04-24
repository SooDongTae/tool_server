package tool.tool.global.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "image")
public class ImageConfig {
    private final String path;

    public ImageConfig(String path) {
        this.path = path;
    }
}
