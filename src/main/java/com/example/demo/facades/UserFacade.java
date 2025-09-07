package com.example.demo.facades;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtos.UserDto;
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
            return null;
        }
    }
}
