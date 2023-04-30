package tool.tool.domain.auth.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tool.tool.domain.auth.presentation.dto.request.RefreshTokenBodyRequest;
import tool.tool.domain.auth.presentation.dto.response.AccessTokenResponse;
import tool.tool.domain.auth.presentation.dto.response.TokenResponse;
import tool.tool.domain.auth.presentation.dto.response.UserResponse;
import tool.tool.domain.auth.service.RefreshAccessTokenService;
import tool.tool.domain.user.service.UserInfoService;
import tool.tool.domain.user.service.UserLoginService;
import tool.tool.domain.user.service.UserLogoutService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLoginService userLoginService;
    private final RefreshAccessTokenService refreshAccessTokenService;
    private final UserLogoutService userLogoutService;
    private final UserInfoService userInfoService;

    @PostMapping("/oauth/bsm")
    public TokenResponse userLogin(HttpServletRequest request){
        return userLoginService.execute(request.getHeader("authCode"));
    }

    @PutMapping("/refresh/access")
    public AccessTokenResponse refreshAccessToken(@RequestBody RefreshTokenBodyRequest request) {
        return refreshAccessTokenService.execute(request.getRefreshToken());
    }

    @DeleteMapping("/logout")
    public void logout(@RequestBody RefreshTokenBodyRequest request) {
        userLogoutService.execute(request.getRefreshToken());
    }

    @GetMapping()
    public UserResponse getUser() {
        return userInfoService.execute();
    }
}
