package tool.tool.domain.auth.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tool.tool.domain.auth.presentation.dto.response.TokenResponseDto;
import tool.tool.domain.user.service.UserLoginService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLoginService userLoginService;

    @PostMapping("/oauth/bsm")
    public TokenResponseDto userLogin(HttpServletRequest request){
        return userLoginService.execute(request.getHeader("authCode"));
    }
}
