package tool.tool.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;
    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
