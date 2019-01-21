package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Data
@Table(name = "Symptom")
public class Symptom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long symptomId;
    private @NonNull String symptom; //อาการป่วย
    
    public Symptom(){}
    public Symptom(String symptom){
         this.symptom = symptom;
    }    
}