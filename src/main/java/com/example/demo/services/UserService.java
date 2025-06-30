package com.example.demo.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Auth.entities.UserEntity;
import com.example.demo.dtos.UserDto;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepo;

    public Optional<UserDto> findByEmail(String email){

        Optional<UserEntity> user = userRepo.findByEmail(email);
        
        return user.map(u -> modelMapper.map(u, UserDto.class));
    }
}
