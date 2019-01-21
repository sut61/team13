package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Data
@Table(name = "Prefix")
public class Prefix{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long prefixId;
    private @NonNull String prefix; //คำนำหน้าชื่อ
    
    public Prefix(){}
    public Prefix(String prefix){
         this.prefix = prefix;
    }    
}