package com.example.demo.facades;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtos.UserDto;
import com.example.demo.models.ApiResponseError;
import com.example.demo.services.UserService;

public class UserFacade {
    
    @Autowired
    UserService userService;

    public Object findByEmail(String email){

        Optional<UserDto> user = userService.findByEmail(email);
    
        if(user.isPresent()){
            return user.get();
        }
        else{
            ApiResponseError error = new ApiResponseError();
            error.setStatusCode(404);
            error.setError("Not Found");
            return error;
        }
    }
}
