package com.example.demo.facades;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EventDescriptionDto;
import com.example.demo.services.EventDescriptionService;

@Service
public class EventDescriptionFacade {

    @Autowired
    private EventDescriptionService eventDescriptionService;

    public Optional<EventDescriptionDto> findByEventId(Long id) {
        return eventDescriptionService.findByEventId(id);
    }
}

