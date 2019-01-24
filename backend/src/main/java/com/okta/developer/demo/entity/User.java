package com.okta.developer.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    private String userName;
    @JsonIgnore
    private String passWord;

    private String position;

    protected User(){}

    public User(Long userId){
        this.id = userId;
    }

    public User(String userName, String passWord , String name, String position){
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.position = position;
    }


}