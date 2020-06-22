package com.soulballad.usage.springcloud.config.jwt;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : jwt token enhancer
 * @since ：2020/6/20 21:14
 */
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("enhancer", "jwt_token_enhancer");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(infoMap);
        return accessToken;
    }
}
