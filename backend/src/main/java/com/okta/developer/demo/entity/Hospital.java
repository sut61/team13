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
@Table(name = "Hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long hospitalId;

    @NotNull(message="hospital must not be null to be valid")
    private String hospital;

    public Hospital(){}
    public Hospital(String hospital){
         this.hospital = hospital;
    }    
   
}
