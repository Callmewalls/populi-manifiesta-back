package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.OptionDto;
import com.example.demo.repositories.EventTypeRepository;

@Service
public class CatalogService {

    @Autowired private EventTypeRepository eventTypeRepository;

    public Map<String, List<OptionDto>> getCatalogs() {
        Map<String, List<OptionDto>> catalogs = new HashMap<>();

        List<OptionDto> eventTypes = eventTypeRepository.findAll()
                .stream()
                .map(e -> new OptionDto(e.getId(), e.getName()))
                .toList();

        catalogs.put("eventTypes", eventTypes);

        return catalogs;
    }
}

