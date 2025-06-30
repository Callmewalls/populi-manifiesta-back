package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.DayDescriptionDto;
import com.example.demo.entities.DayDescriptionEntity;
import com.example.demo.repositories.DayDescriptionRepository;

@Service
public class DayDescriptionService extends BasicServiceImpl<DayDescriptionEntity, DayDescriptionDto, Long>{

    @Autowired
    DayDescriptionRepository dayDescriptionRepository;

    public DayDescriptionService(DayDescriptionRepository dayDescriptionRepository) {
        super(dayDescriptionRepository, DayDescriptionEntity.class, DayDescriptionDto.class);
    }

    
    public Optional<DayDescriptionDto> getDescriptionForEvent(Long id) {
        return this.dayDescriptionRepository.findByEventId(id)
            .map(entity -> modelMapper.map(entity, DayDescriptionDto.class));
    }
    

    
    public List<DayDescriptionDto> getDescriptions(Long id) {
        return this.mapToList(this.dayDescriptionRepository.findAll());
    }





}
