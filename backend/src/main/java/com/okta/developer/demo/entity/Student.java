package com.okta.developer.demo.entity;

import javax.persistence.*;
@Table(name="Student")
public class Student{
    //private @NonNull 
    long id;



    public void setId(long id){
        this.id = id;
    }

}
