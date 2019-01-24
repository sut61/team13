package com.okta.developer.demo.entity;

import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Students {
    @Id
    @SequenceGenerator(name="s_seq",sequenceName="s_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="s_seq")
    private @NonNull Long id;

    private String name;
    private String studentid ;
    private String num ;


    @ManyToOne(fetch = FetchType.LAZY)
    private Nationality nationality;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genders gender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Religion religion;

    public Students(){}

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

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }




}
