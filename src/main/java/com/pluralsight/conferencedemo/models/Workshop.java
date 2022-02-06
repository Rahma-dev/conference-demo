package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "workshops")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id", nullable = false)
    private Integer workshop_id;
    private String workshop_name;
    private String description;
    private String requirements;
    private String room;
    private Integer capacity;

    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "workshop_speakers",
            joinColumns = @JoinColumn(name ="speaker_id"),
            inverseJoinColumns = @JoinColumn(name= "workshop_id"))
    private List<Speaker> speakers;

    public Integer getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(Integer workshop_id) {
        this.workshop_id = workshop_id;
    }

    public Workshop() {
    }

    public String getWorkshop_name() {
        return workshop_name;
    }

    public void setWorkshop_name(String workshop_name) {
        this.workshop_name = workshop_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
