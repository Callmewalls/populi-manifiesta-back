package com.example.demo.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProgrammedEventDto;
import com.example.demo.dtos.ProgrammedEventOrganizerDto;
import com.example.demo.services.ProgrammedEventService;

@Service
public class ProgrammedEventFacade {

    ProgrammedEventService programmedEventService;
    

    @Autowired
    public ProgrammedEventFacade(ProgrammedEventService programmedEventService) {
        this.programmedEventService = programmedEventService;
    }




    public List<ProgrammedEventDto> getAllEventsForDateTime(String dateTimeString){

        
        return this.programmedEventService.getProgrammedEventsForDateTime(dateTimeString);
    }

    public List<ProgrammedEventOrganizerDto> getAllEventsForDate(String dateTimeString){

        
        return this.programmedEventService.getProgrammedEventsForDate(dateTimeString);
    }

    public ProgrammedEventDto createEvent(ProgrammedEventDto event){
        return this.programmedEventService.save(event);
    }
}

