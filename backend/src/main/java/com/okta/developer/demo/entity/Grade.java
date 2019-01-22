package com.okta.developer.demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name="grade")
public class Grade {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Id
    @SequenceGenerator(name="grade_seq",sequenceName="grade_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grade_seq")
    @Column(name="GRADE_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull int point;



    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Student.class)
    @JoinColumn(name = "STUDENT_ID", insertable = true)
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Professor.class)
    @JoinColumn(name = "PROFESSOR_ID", insertable = true)
    private Professor professor;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Major.class)
    @JoinColumn(name = "major_ID", insertable = true)
    private Major major;

    public Gpa getGpa() {
        return gpa;
    }

    public void setGpa(Gpa gpa) {
        this.gpa = gpa;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Major.class)
    @JoinColumn(name = "Gpa_ID", insertable = true)
    private Gpa gpa;



    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }



    public void setMajor(Major major) {
        this.major = major;
    }

    public Major getMajor() {
        return major;
    }

    public Grade(){}

    public Grade(int point ,Major major, Professor professor,Student student,Gpa gpa){
        this.point = point;
        this.gpa =gpa ;
        this.professor = professor;
        this.major = major;
        this.student = student;
    }
}
