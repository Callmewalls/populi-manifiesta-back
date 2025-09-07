package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity()
@Table(name="event_type")
public class EventTypeEntity extends BasicEntity{
    
    @Column(name = "name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
