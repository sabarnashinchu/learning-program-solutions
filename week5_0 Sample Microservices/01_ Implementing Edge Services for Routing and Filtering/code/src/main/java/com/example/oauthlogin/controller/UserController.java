package com.example.oauthlogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "<h1>Welcome to the OAuth2 Login App</h1><a href=\"/user\">Login with Google</a>";
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
