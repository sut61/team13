package com.okta.developer.demo.entity;
import lombok.*;

import java.util.*;
import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name="SchoolCheck")
public class SchoolCheck {
    @Id
    @SequenceGenerator(name="schoolcheck_seq",sequenceName="schoolcheck_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="schoolcheck_seq")
    private @NonNull Long id;


    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 5 ,max = 20)
    @Column(unique = true)
    private String Parrents;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date Datecome;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Status status;

    @ManyToOne
    private Parents parents;

    @ManyToOne
    private Classrooms classrooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatecome() {
        return Datecome;
    }

    public void setDatecome(Date datecome) {
        Datecome = datecome;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }

    public Classrooms getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Classrooms classrooms) {
        this.classrooms = classrooms;
    }
    public SchoolCheck(){}

    public String getParrents() {
        return Parrents;
    }

    public void setParrents(String parrents) {
        Parrents = parrents;
    }
    public SchoolCheck(Date Datecome,Student Student, Classrooms Classrooms, Status Status, Parents Parent, String Parrents){
        this.Datecome = Datecome;
        this.student = Student;
        this.classrooms = Classrooms;
        this.status = Status;
        this.parents = Parent;
        this.Parrents = Parrents;
    }
}
