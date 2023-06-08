package tool.tool.domain.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.tool.domain.user.domain.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long>, ParticipantRepositoryCustom {
}
