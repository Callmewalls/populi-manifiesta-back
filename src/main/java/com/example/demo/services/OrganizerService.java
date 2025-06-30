package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.OrganizerDto;
import com.example.demo.entities.OrganizerEntity;
import com.example.demo.repositories.OrganizerRepository;

@Service
public class OrganizerService extends BasicServiceImpl<OrganizerEntity, OrganizerDto, Long>{

    public OrganizerService(OrganizerRepository repository) {
        super(repository, OrganizerEntity.class, OrganizerDto.class);
    }
}
