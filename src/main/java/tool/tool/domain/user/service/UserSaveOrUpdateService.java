package tool.tool.domain.user.service;

import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import leehj050211.bsmOauth.exception.BsmOAuthCodeNotFoundException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import leehj050211.bsmOauth.exception.BsmOAuthTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.user.domain.StuNumber;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.UserRepository;
import tool.tool.domain.user.domain.type.Authority;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSaveOrUpdateService {
    private final BsmOauth bsmOauth;
    private final UserRepository userRepository;
    public User execute(String authCode) {
        String token;
        BsmUserResource resource;
        try {
            token = bsmOauth.getToken(authCode);
            resource = bsmOauth.getResource(token);
        } catch (IOException | BsmOAuthCodeNotFoundException | BsmOAuthInvalidClientException |
                 BsmOAuthTokenNotFoundException e) {
            throw new RuntimeException(e);
        }
        return saveOrUpdate(resource);
    }

    private User saveOrUpdate(BsmUserResource resource) {
        Optional<User> user = userRepository.findByEmail(resource.getEmail());
        if(user.isEmpty()) {
            return saveUser(resource);
        }
        return user.get().update(resource);
    }

    private User saveUser(BsmUserResource resource) {
        return userRepository.save(User.builder()
                        .email(resource.getEmail())
                        .name(resource.getStudent().getName())
                        .stuNumber(StuNumber.builder()
                                .grade(resource.getStudent().getGrade())
                                .ban(resource.getStudent().getClassNo())
                                .num(resource.getStudent().getStudentNo())
                                .build()
                        )
                        .authority(Authority.ROLE_USER)
                        .build()
                );
    }

}
