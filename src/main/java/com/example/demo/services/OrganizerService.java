package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.OrganizerDto;
import com.example.demo.entities.OrganizerEntity;
import com.example.demo.repositories.OrganizerRepository;

@Service
public class OrganizerService extends BasicServiceImpl<OrganizerEntity, OrganizerDto, Long>{

    public OrganizerService(OrganizerRepository repository) 
    {
        super(
            repository, 
            OrganizerEntity.class, 
            OrganizerDto.class
        );
    }
}
