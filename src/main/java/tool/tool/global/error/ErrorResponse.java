package tool.tool.global.error;


import lombok.AllArgsConstructor;
import lombok.Getter;
import tool.tool.global.error.exception.ErrorProperty;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;

    public String toString(){
        return "{\n" +
                "\t\"status\": " + status +
                "\n\t\"message\": " + message +
                "\n}";
    }

    public ErrorResponse(ErrorProperty errorProperty) {
        this.status = errorProperty.getStatus();
        this.message = errorProperty.getMessage();
    }
}
