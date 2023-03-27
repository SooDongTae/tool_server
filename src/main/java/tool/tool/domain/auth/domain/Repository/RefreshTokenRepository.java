package tool.tool.domain.auth.domain.Repository;

import org.springframework.data.repository.CrudRepository;
import tool.tool.domain.auth.domain.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
