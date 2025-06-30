package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "organizer")
public class OrganizerEntity extends BasicEntity {


    @Column(name = "nif", nullable = false, unique = true, length = 16)
    private String nif;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "location_id", nullable = false)
    private Long locationId;

    // Getters y setters
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
