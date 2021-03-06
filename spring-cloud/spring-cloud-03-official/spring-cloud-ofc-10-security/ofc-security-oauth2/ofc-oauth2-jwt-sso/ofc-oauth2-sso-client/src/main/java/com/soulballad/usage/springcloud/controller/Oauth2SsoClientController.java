package com.soulballad.usage.springcloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/21 20:07
 */
@RestController
public class Oauth2SsoClientController {

    @GetMapping(value = "/normal")
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public String normal() {
        return "normal permission access successful!";
    }

    @GetMapping(value = "/medium")
    @PreAuthorize("hasAuthority('ROLE_MEDIUM')")
    public String medium() {
        return "medium permission access successful!";
    }

    @GetMapping(value = "/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "admin permission access successful!";
    }
}
