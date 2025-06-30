package com.example.demo.facades;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.OrganizerDto;
import com.example.demo.services.OrganizerService;

@Service
public class OrganizerFacade {

    private final OrganizerService organizerService;

    @Autowired
    public OrganizerFacade(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    public List<OrganizerDto> getAllOrganizers() {
        return organizerService.findAll();
    }

    public Optional<OrganizerDto> getOrganizerById(Long id) {
        return organizerService.findById(id);
    }

    public OrganizerDto saveOrganizer(OrganizerDto dto) {
        return organizerService.save(dto);
    }

    public void deleteOrganizer(Long id) {
        organizerService.deleteById(id);
    }
}
