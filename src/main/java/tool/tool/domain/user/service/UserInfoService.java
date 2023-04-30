package tool.tool.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tool.tool.domain.auth.presentation.dto.response.UserResponse;
import tool.tool.domain.user.facade.UserFacade;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserFacade userFacade;

    public UserResponse execute() {
        return UserResponse.of(userFacade.getCurrentUser());
    }

}
