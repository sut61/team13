package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;
@Entity
@Data
@Table(name = "Prefix")
public class Prefix{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long prefixId;

    @NotNull(message="prefix must not be null to be valid")
    @Column(unique = true)
    private String prefix; //คำนำหน้าชื่อ

    public Prefix(){}
    public Prefix(String prefix){
         this.prefix = prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getPrefix(){
        return prefix;
    }

    public void setPrefixId(long prefixId) {
        this.prefixId = prefixId;
    }

    public long getPrefixId() {
        return prefixId;
    }
}
