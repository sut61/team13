package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@Table(name = "Treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long treatmentId;

    @NotNull(message="treatment must not be null to be valid")
    @Column(unique = true)
    private String treatment; //การรักษา
    
    public Treatment(){}
    public Treatment(String treatment){
         this.treatment = treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    public String getTreatment(){
        return treatment;
    }
}
