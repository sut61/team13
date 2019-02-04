package com.okta.developer.demo.entity;
import lombok.*;

import javax.persistence.*;
@Entity
@ToString
@EqualsAndHashCode
@Table(name="Classrooms")
public class Classrooms {
    @Id
    @SequenceGenerator(name="classroom_seq",sequenceName="classroom_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="classroom_seq")
    private @NonNull Long id;
    private @NonNull String classroom;
    public Classrooms(){}
    public Classrooms(String classroom){
        this.classroom = classroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
