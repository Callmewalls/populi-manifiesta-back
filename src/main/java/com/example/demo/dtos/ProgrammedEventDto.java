package com.example.demo.dtos;

import org.springframework.stereotype.Component;

@Component
public class ProgrammedEventDto extends BasicDto {
    
    
    private String dateTime;
    
    private Long organizerId;
    
    private Long signs;
    
    private Long eventId;
    
    private Long locationId;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public Long getSigns() {
        return signs;
    }

    public void setSigns(Long signs) {
        this.signs = signs;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }   


}
