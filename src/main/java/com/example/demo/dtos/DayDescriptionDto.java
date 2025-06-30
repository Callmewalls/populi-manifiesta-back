package com.example.demo.dtos;

import org.springframework.stereotype.Component;

@Component
public class DayDescriptionDto extends BasicDto{
    
    private String description;
    
    private String imageUrl;
    
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
