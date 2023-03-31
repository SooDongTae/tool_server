package tool.tool.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ToolException extends RuntimeException{

    private final ErrorProperty errorProperty;
}
