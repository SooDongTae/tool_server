package tool.tool.domain.user.facade;

import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.UserRepository;
import tool.tool.domain.user.domain.type.Authority;
import tool.tool.domain.user.domain.type.StuNumber;
import tool.tool.domain.user.exception.UserNotFoundException;
import tool.tool.global.security.jwt.auth.AuthDetails;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;
    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    @Transactional
    public User saveUser(BsmUserResource resource) {
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

    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }
}
