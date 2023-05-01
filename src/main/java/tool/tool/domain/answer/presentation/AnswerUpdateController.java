package tool.tool.domain.answer.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
@RequiredArgsConstructor
public class AnswerUpdateController {

    @PutMapping("/{id}")
    public void updateAnswer(@PathVariable Long id) {

    }

}
