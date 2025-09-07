package com.example.demo.dtos;

public class OrganizerDto extends BasicDto {

    private String nif;
    private String name;
    private String lastNames;
    private String email;
    private Long phone;
    private Long locationId;
    private String respName;
    private String respNif;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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