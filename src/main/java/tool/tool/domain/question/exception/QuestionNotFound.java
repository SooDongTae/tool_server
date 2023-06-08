package tool.tool.domain.question.exception;

import tool.tool.domain.question.exception.error.QuestionErrorProperty;
import tool.tool.global.error.exception.ToolException;

public class QuestionNotFound extends ToolException {

    public final static QuestionNotFound EXCEPTION = new QuestionNotFound();

    public QuestionNotFound() {
        super(QuestionErrorProperty.QUESTION_NOT_FOUND);
    }
}
