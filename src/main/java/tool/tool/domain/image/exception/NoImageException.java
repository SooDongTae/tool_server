package tool.tool.domain.image.exception;

import tool.tool.domain.image.exception.error.ImageErrorProperty;
import tool.tool.global.error.exception.ErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class NoImageException extends ToolException {

    public final static NoImageException EXCEPTION = new NoImageException();

    private NoImageException() {
        super(ImageErrorProperty.NO_IMAGE_EXCEPTION);
    }
}
