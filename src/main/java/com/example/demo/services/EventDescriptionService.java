package com.example.demo.services;

import com.example.demo.dtos.DayDescriptionDto;
import com.example.demo.dtos.EventDescriptionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.DayDescriptionEntity;
import com.example.demo.entities.EventDescriptionEntity;
import com.example.demo.repositories.DayDescriptionRepository;
import com.example.demo.repositories.EventDescriptionRepository;

@Service
public class EventDescriptionService extends BasicServiceImpl<EventDescriptionEntity, EventDescriptionDto, Long>{


    @Autowired
    private EventDescriptionRepository repository;


    public EventDescriptionService(EventDescriptionRepository eventDescriptionRepository) {
        super(eventDescriptionRepository, EventDescriptionEntity.class, EventDescriptionDto.class);
    }


    public Optional<EventDescriptionDto> findByEventId(Long id) {

        return this.repository.findByEventId(id)
            .map(entity -> modelMapper.map(entity, EventDescriptionDto.class));
    }


}

