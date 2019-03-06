package com.okta.developer.demo.entity;



import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "Classroom")
public class Classroom {

    @Id
    @SequenceGenerator(name = "cla_seq", sequenceName = "cla_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cla_seq")
    private @NonNull
    Long id;
    @NotNull
    private String classroom;

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

