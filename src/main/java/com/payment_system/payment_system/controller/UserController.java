package com.payment_system.payment_system.controller;

import com.payment_system.payment_system.dto.AuthenticationRequest;
import com.payment_system.payment_system.dto.AuthenticationResponse;
import com.payment_system.payment_system.dto.UserRequest;
import com.payment_system.payment_system.dto.UserResponse;
import com.payment_system.payment_system.entity.User;
import com.payment_system.payment_system.service.TokenService;
import com.payment_system.payment_system.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest) throws MessagingException, UnsupportedEncodingException {
        User user = userRequest.toModel();
        UserResponse userSaved = userService.registerUser(user);
        return ResponseEntity.ok().body(userSaved);
    }


    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code){
        if(userService.verify(code)){
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }

    @GetMapping("/teste")
    public String teste() {
        return "você está logado";
    }
}
