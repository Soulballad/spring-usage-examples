package com.soulballad.usage.springcloud.config;

//import com.soulballad.usage.springcloud.enhancer.JwtTokenEnhancer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : jwt token store
 * @since ：2020/6/20 21:12
 */
//@Configuration
//public class JwtTokenStoreConfig {

//    @Bean
//    @Primary
//    public TokenStore jwtTokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    @Bean
//    public JwtTokenEnhancer jwtTokenEnhancer() {
//        return new JwtTokenEnhancer();
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
//        tokenConverter.setSigningKey("test_sign_key");
//        return tokenConverter;
//    }
//}
