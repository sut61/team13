package com.okta.developer.demo.entity;
import lombok.*;

import java.util.*;
import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@EqualsAndHashCode
@Table(name="SchoolCheck")
public class SchoolCheck {
    @Id
    @SequenceGenerator(name="schoolcheck_seq",sequenceName="schoolcheck_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="schoolcheck_seq")
    private @NonNull Long id;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date Datecome;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Student.class)
    @JoinColumn(name = "STUDENT_ID", insertable = true)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity =  Status.class)
    @JoinColumn(name = "Status",unique = true, nullable = true)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity =  Parents.class)
    @JoinColumn(name = "Parents",unique = true, nullable = true)
    private Parents parents;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity =  Classrooms.class)
    @JoinColumn(name = "Classrooms",unique = true, nullable = true)
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

    public SchoolCheck(Date Datecome,Student Student, Classrooms Classrooms, Status Status, Parents Parent){
        this.Datecome = Datecome;
        this.student = Student;
        this.classrooms = Classrooms;
        this.status = Status;
        this.parents = Parent;
    }
}
