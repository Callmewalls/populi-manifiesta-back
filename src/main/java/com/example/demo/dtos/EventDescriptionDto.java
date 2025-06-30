package com.example.demo.dtos;

import org.springframework.stereotype.Component;

@Component
public class EventDescriptionDto extends BasicDto {

    private String imageUrl;
    private Integer programmedEventId;
    private String objectivesText;
    private String eventName;
    private String locationSrc;
    private String eventDescription;

    // Getters y setters
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getProgrammedEventId() {
        return programmedEventId;
    }

    public void setProgrammedEventId(Integer programmedEventId) {
        this.programmedEventId = programmedEventId;
    }

    public String getObjectivesText() {
        return objectivesText;
    }

    public void setObjectivesText(String objectivesText) {
        this.objectivesText = objectivesText;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocationSrc() {
        return locationSrc;
    }

    public void setLocationSrc(String locationSrc) {
        this.locationSrc = locationSrc;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
