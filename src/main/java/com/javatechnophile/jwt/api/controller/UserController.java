package com.javatechnophile.jwt.api.controller;

import com.javatechnophile.jwt.api.entity.AuthRequest;
import com.javatechnophile.jwt.api.entity.User;
import com.javatechnophile.jwt.api.service.UserService;
import com.javatechnophile.jwt.api.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Valid
    @GetMapping(value = "/getUsers",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest){
        log.info(" Request is {}, {}",authRequest.getUserName(),authRequest.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        }catch (Exception e){
            throw new RuntimeException("Invalid username/password");
        }
        return  jwtUtil.generateToken(authRequest.getUserName());
        }
    @PostMapping("invalidateToken")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String token = jwtUtil.extractToken(request);
        // Clear any session-related data if necessary
        return ResponseEntity.ok("Logged out successfully");
    }
}
