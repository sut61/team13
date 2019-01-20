package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long hospitalId;
    private @NonNull String referral; // การส่งต่อผู้ป่วย
    
    public Hospital(){}
    public Hospital(String referral){
         this.referral = referral;
    }    
   
}