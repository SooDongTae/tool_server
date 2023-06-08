package tool.tool.domain.auth.service;

import leehj050211.bsmOauth.BsmOauth;
import leehj050211.bsmOauth.dto.resource.BsmUserResource;
import leehj050211.bsmOauth.exception.BsmOAuthCodeNotFoundException;
import leehj050211.bsmOauth.exception.BsmOAuthInvalidClientException;
import leehj050211.bsmOauth.exception.BsmOAuthTokenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class OauthGetResourceService {

    private final BsmOauth bsmOauth;

    public BsmUserResource execute(String authCode) {
        String token;
        BsmUserResource resource;
        try {
            token = bsmOauth.getToken(authCode);
            resource = bsmOauth.getResource(token);
        } catch (IOException | BsmOAuthCodeNotFoundException | BsmOAuthInvalidClientException |
                 BsmOAuthTokenNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resource;
    }
}
