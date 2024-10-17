package com.example.mutant_detector.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ADN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String [] sequence;

    public ADN(){

    }
    public ADN(String[] sequence) {
        this.sequence = sequence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getSequence() {
        return sequence;
    }

    public void setSequence(String[] sequence) {
        this.sequence = sequence;
    }
}