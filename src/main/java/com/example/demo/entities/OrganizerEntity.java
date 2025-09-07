package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizer")
public class OrganizerEntity extends BasicEntity {


    @Column(name = "nif", nullable = false, unique = true, length = 16)
    private String nif;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "last_names", length = 100)
    private String lastNames;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "resp_name", length = 100)
    private String respName;

    @Column(name = "resp_nif", length = 100)
    private String respNif;

    @Column(name = "resp_phone")
    private Long respPhone;

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

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getRespName() {
        return respName;
    }

    public void setRespName(String respName) {
        this.respName = respName;
    }

    public String getRespNif() {
        return respNif;
    }

    public void setRespNif(String respNif) {
        this.respNif = respNif;
    }

    public Long getRespPhone() {
        return respPhone;
    }

    public void setRespPhone(Long respPhone) {
        this.respPhone = respPhone;
    }
}