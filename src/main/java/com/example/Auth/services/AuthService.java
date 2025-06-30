package com.example.Auth.services;

import com.example.demo.dtos.UserDto;
import com.example.demo.services.UserService;
import com.example.demo.utils.JwtUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // Tu clave secreta en formato String
    private static final String SECRET_KEY = "miClaveSecretaSuperSeguraQueDeberíaSerLarga";


    public String login(String email, String password) {
        
        Optional<UserDto> user = userService.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return jwtUtil.generateToken(email);
        }
        return null;
    }

}
