package com.example.Auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Auth.interfaces.Credentials;
import com.example.Auth.services.AuthService;
import com.example.demo.models.BasicResponse;
import com.example.demo.models.TokenResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@EnableAutoConfiguration
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    @Operation(summary = "Login endpoint", description = "Allows the user to log in with email and password.", operationId = "login")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "404",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = BasicResponse.class)
            )
        )
    })
    public ResponseEntity login(@Valid @RequestBody Credentials credentials){

        String token = this.authService.login(credentials.getEmail(), credentials.getPassword());

        if(token != null){
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(token);
            return ResponseEntity.status(201).body(BasicResponse.success("Usuario o contraseña correctos", tokenResponse));
        }
        else {
            return ResponseEntity.status(500).body(BasicResponse.error("Usuario o contraseña invalidos", 404));
        }


    }
}
