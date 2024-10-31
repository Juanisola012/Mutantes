package com.example.mutant_detector.model;

import jakarta.persistence.*;

@Entity
public class ADN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sequence;

    @Column(name = "is_mutant")
    private Boolean isMutant;

    public ADN(){

    }

    public Boolean isMutant() {
        return isMutant;
    }

    public void setMutant(Boolean mutant) {
        isMutant = mutant;
    }

    public ADN(Long id, String sequence, Boolean isMutant) {
        this.id = id;
        this.sequence = sequence;
        this.isMutant = isMutant;
    }

    public ADN(String sequence) {
        this.sequence = sequence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}