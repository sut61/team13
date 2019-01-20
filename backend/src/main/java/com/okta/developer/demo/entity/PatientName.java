package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "PatientName")
public class PatientName {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long id;
    private @NonNull String prefix; //คำนำหน้าชื่อ
    private @NonNull String patientName;
       
    public PatientName(String patientName){
        this.patientName = patientName;
    }

}