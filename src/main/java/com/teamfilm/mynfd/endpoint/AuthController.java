package com.teamfilm.mynfd.endpoint;

//import com.teamfilm.mynfd.security.JWTHelper;
import com.teamfilm.mynfd.response.ApiResponse;
import com.teamfilm.mynfd.security.JWTHelper;
import com.teamfilm.mynfd.service.JWTRequest;
import com.teamfilm.mynfd.service.JWTResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.SignatureException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserDetailsService userDetailsService;


    private final AuthenticationManager manager;

    private final JWTHelper helper;


    public AuthController(UserDetailsService userDetailsService, AuthenticationManager manager, JWTHelper helper) {
        this.userDetailsService = userDetailsService;
        this.manager = manager;
        this.helper = helper;
    }

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        JWTResponse response = JWTResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ApiResponse exceptionHandler() {
        return new ApiResponse("Credentials invalid!", false);
    }
}
