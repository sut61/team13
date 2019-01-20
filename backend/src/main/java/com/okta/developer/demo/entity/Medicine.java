package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long medicineId;
    private @NonNull String dispensation; //การจ่ายยา
    
    public Medicine(){}
    public Medicine(String dispensation){
         this.dispensation = dispensation;
    }    
}