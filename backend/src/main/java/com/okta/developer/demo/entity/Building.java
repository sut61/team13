package com.okta.developer.demo.entity;



import javax.persistence.*;
import lombok.*;
@Entity
@Table(name = "Building")
public class Building {

    @Id
    @SequenceGenerator(name="bui_seq",sequenceName="bui_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bui_seq")
    private @NonNull Long id;

    private String Building ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String building) {
        this.Building = building;
    }


    public Building(){}

}
