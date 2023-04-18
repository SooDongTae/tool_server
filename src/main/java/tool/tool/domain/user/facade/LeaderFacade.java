package tool.tool.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tool.tool.domain.user.domain.Leader;
import tool.tool.domain.user.domain.User;
import tool.tool.domain.user.domain.repository.LeaderRepository;

@Component
@RequiredArgsConstructor
public class LeaderFacade {
    private final LeaderRepository leaderRepository;

    @Transactional
    public Leader saveLeader(User user, String bank, String account) {
        return leaderRepository.save(Leader.builder()
                .user(user)
                .accountBank(bank)
                .accountNum(account)
                .build());
    }
}
