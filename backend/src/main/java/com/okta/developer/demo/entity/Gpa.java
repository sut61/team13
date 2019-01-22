package com.okta.developer.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;


@Entity
@ToString
@EqualsAndHashCode
@Table(name="GPAX")
public class Gpa {
    @Id
    @SequenceGenerator(name="gpa",sequenceName="gpa")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gpa")
    private @NonNull Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGgpa() {
        return ggpa;
    }

    public void setGgpa(String ggpa) {
        this.ggpa = ggpa;
    }

    private  String ggpa ;

    public Gpa(){}
}
