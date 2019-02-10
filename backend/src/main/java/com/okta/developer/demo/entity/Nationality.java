package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "Nationality")
public class Nationality {
    @Id
    @SequenceGenerator(name="na_seq",sequenceName="na_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="na_seq")
    private @NonNull Long id;

    private String nation ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }


    public Nationality(){}

}
