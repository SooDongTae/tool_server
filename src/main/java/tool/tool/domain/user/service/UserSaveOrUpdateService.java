package tool.tool.domain.user.service;

import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.auth.service.OauthGetResourceService;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.UserRepository;
import tool.tool.domain.user.facade.UserFacade;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSaveOrUpdateService {

    private final OauthGetResourceService oauthGetResourceService;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public User execute(String authCode) {
        return saveOrUpdate(oauthGetResourceService.execute(authCode));
    }

    private User saveOrUpdate(BsmUserResource resource) {
        Optional<User> user = userRepository.findByEmail(resource.getEmail());
        if(user.isEmpty()) {
            return userFacade.saveUser(resource);
        }
        return user.get().update(resource);
    }



}
