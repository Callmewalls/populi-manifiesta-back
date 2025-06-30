package com.example.demo.entities;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "programmed_events")
public class ProgrammedEventEntity extends BasicEntity{

    @Column(name="date_time" ,nullable = false)    
    private LocalDateTime dateTime;
    
    @Column(name="organizer_id" ,nullable = false)
    private Long organizerId;
    
    @Column(name="signs" ,nullable = false)
    private Long signs;
    
    @Column(name="event_type_id" ,nullable = false)
    private Long eventId;
    
    @Column(name="location_id" ,nullable = false)
    private Long locationId;
    

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public void setDateTime(LocalDateTime dateTime) {
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

    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
        result = prime * result + ((organizerId == null) ? 0 : organizerId.hashCode());
        result = prime * result + ((signs == null) ? 0 : signs.hashCode());
        result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
        result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProgrammedEventEntity other = (ProgrammedEventEntity) obj;
        if (dateTime == null) {
            if (other.dateTime != null)
                return false;
        } else if (!dateTime.equals(other.dateTime))
            return false;
        if (organizerId == null) {
            if (other.organizerId != null)
                return false;
        } else if (!organizerId.equals(other.organizerId))
            return false;
        if (signs == null) {
            if (other.signs != null)
                return false;
        } else if (!signs.equals(other.signs))
            return false;
        if (eventId == null) {
            if (other.eventId != null)
                return false;
        } else if (!eventId.equals(other.eventId))
            return false;
        if (locationId == null) {
            if (other.locationId != null)
                return false;
        } else if (!locationId.equals(other.locationId))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "ProgrammedEventEntity [dateTime=" + dateTime + ", organizerId=" + organizerId
                + ", signs=" + signs + ", eventId=" + eventId + ", locationId=" + locationId + "]";
    }


    

}
