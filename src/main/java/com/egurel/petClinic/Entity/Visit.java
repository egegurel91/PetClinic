package com.egurel.petClinic.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitId;

    private String visitDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petsId")
    @JsonIgnore
    private Pet pet;

    public Visit() {
    }

    public Visit(String visitDescription) {
        this.visitDescription = visitDescription;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getVisitDescription() {
        return visitDescription;
    }

    public void setVisitDescription(String visitDescription) {
        this.visitDescription = visitDescription;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
