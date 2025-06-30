package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "day_description")
public class DayDescriptionEntity extends BasicEntity{
    
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "programmed_event_id")
    private long programmedEventId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getProgrammedEventId() {
        return programmedEventId;
    }

    public void setProgrammedEventId(long programmedEventId) {
        this.programmedEventId = programmedEventId;
    }

}
