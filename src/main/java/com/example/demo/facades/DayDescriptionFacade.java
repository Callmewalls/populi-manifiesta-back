package com.example.demo.facades;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.DayDescriptionDto;
import com.example.demo.services.DayDescriptionService;

@Service
public class DayDescriptionFacade {
    
    @Autowired
    DayDescriptionService dayDescriptionService;

    public Optional<DayDescriptionDto> getDescriptionForEvent(Long id){

        return dayDescriptionService.getDescriptionForEvent(id);
    }
}
