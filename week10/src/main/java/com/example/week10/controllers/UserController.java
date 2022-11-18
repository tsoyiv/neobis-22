package com.example.week10.controllers;

import com.example.week10.entity.Request;
import com.example.week10.entity.Response;
import com.example.week10.service.UserService;
import com.example.week10.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String home() {
        return "Welcome to the home page";
    }
    @PostMapping("/auth")
    public Response auth(@RequestBody Request request) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("invalid", e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        final String token = jwtUtility.generateToken(userDetails);
        return new Response(token);
    }
}
