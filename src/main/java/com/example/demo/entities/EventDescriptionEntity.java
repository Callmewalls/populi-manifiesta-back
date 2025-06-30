package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_description") // Usa el nombre real de la tabla
public class EventDescriptionEntity extends BasicEntity {

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "programmed_event_id", nullable = false)
    private Integer programmedEventId;

    @Column(name = "objectives_text", nullable = false)
    private String objectivesText;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "location_src")
    private String locationSrc;

    @Column(name = "event_description", nullable = false, columnDefinition = "TEXT")
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

    public String geteventName() {
        return eventName;
    }

    public void seteventName(String eventName) {
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
