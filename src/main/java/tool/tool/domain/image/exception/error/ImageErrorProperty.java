package tool.tool.domain.image.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@RequiredArgsConstructor
public enum ImageErrorProperty implements ErrorProperty {

    NO_IMAGE_EXCEPTION(400, "No Image");

    private final int status;
    private final String message;
}
