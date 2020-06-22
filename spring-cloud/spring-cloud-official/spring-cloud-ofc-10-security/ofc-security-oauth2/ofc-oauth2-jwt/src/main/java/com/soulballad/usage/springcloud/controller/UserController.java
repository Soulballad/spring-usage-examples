package com.soulballad.usage.springcloud.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : user controller
 * @since ：2020/6/20 21:36
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/currentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {

//        String authHeader = request.getHeader("Authorization");
//        String token = authHeader.substring(authHeader.indexOf("bearer"));
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String jwtToken = details.getTokenValue();
        return Jwts.parser()
                .setSigningKey("test_sign_key".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    @GetMapping(value = "/getUser")
    public Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
