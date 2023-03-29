package tool.tool.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.LeaderRepository;

@Component
@RequiredArgsConstructor
public class LeaderFacade {
    private final LeaderRepository leaderRepository;

    public Leader saveLeader(User user) {
        return leaderRepository.save(Leader.builder()
                .user(user)
                .build());
    }
}
