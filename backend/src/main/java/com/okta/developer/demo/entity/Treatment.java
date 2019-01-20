package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long treatmentId;
    private @NonNull String treatment; //ตัวยาสำคัญ
    
    public Treatment(){}
    public Treatment(String treatment){
         this.treatment = treatment;
    }    
   
}