package com.soulballad.usage.springcloud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : provider
 * @since ：2020/6/12 21:03
 */
@RestController
public class ProviderController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "this is csl provider!";
    }

    @GetMapping(value = "/health-check")
    public ResponseEntity<String> healthCheck() {
        String message = "customer health check method!";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
