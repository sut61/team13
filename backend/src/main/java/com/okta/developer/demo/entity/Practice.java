package com.okta.developer.demo.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.*;
@Entity
public class Practice {

    @Id
    @SequenceGenerator(name = "pra_seq", sequenceName = "pra_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pra_seq")
    private @NonNull
    Long id;


    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 5, max = 20)
    @Column(unique = true)
    private String name;
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 5, max = 20)
    @Column(unique = true)
    private String particulars;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date Day;

    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    private Roomm roomm;

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

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Roomm getRoomm() {
        return roomm;
    }

    public void setRoomm(Roomm roomm) {
        this.roomm = roomm;
    }
}