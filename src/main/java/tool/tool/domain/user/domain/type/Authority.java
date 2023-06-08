package tool.tool.domain.user.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority {
    ROLE_USER("USER"), ROLE_ADMIN("ADMIN");

    private final String role;
}
