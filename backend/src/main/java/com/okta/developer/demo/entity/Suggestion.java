package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Suggestion")
public class Suggestion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long suggestionId;
    private String suggestion; //ข้อแนะนำ
    
    public Suggestion(){}
    public Suggestion(String suggestion){
        this.suggestion = suggestion;
    }    
   
}