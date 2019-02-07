package com.okta.developer.demo.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Practice {

    @Id
    @SequenceGenerator(name = "pra_seq", sequenceName = "pra_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra_seq")
    private @NonNull Long id;

    private String name;
    private String num;


    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date Day;

    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cla cla;

    @ManyToOne(fetch = FetchType.LAZY)
    private Roomm roomm;

    public Practice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getDay() {
        return Day;
    }

    public void setDay(Date day) {
        Day = day;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Cla getCla() {
        return cla;
    }

    public void setCla(Cla cla) {
        this.cla = cla;
    }

    public Roomm getRoomm() {
        return roomm;
    }

    public void setRoomm(Roomm roomm) {
        this.roomm = roomm;
    }

}