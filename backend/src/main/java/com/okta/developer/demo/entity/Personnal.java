package com.okta.developer.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Table(name = "Personnal")
public class Personnal {
    @Id
    @SequenceGenerator(name="Personnal_seq",sequenceName="Personnal_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Personnal_seq")
    @Column(name="Personnal_ID",unique = true, nullable = true)
    private   @NonNull String fname;
    private   @NonNull String Lname;
    private   @NonNull String nationality;
    private   @NonNull String educational;
    private   @NonNull String IdentificationNumber;
    private   @NonNull String job_id;
    private   @NonNull String phonenumber;
    private   @NonNull String E_mail;
    private   @NonNull String extraction;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date Birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Gender")    private Genders Gender ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Religion")    private Religion Religion ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Position ")    private Position Position ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Degree ")    private Degree Degree ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Education ")    private Education Education ;

    public Personnal(){}

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEducational() {
        return educational;
    }

    public void setEducational(String educational) {
        this.educational = educational;
    }

    public String getIdentificationNumber() {
        return IdentificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        IdentificationNumber = identificationNumber;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getExtraction() {
        return extraction;
    }

    public void setExtraction(String extraction) {
        this.extraction = extraction;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public Genders getGenders() {
        return Gender;
    }

    public void setGenders(Genders gender) {
        Gender = gender;
    }

    public Religion getReligion() {
        return Religion;
    }

    public void setReligion(Religion religion) {
        Religion = religion;
    }

    public Position getPosition() {
        return Position;
    }

    public void setPosition(Position position) {
        Position = position;
    }

    public Degree getDegree() {
        return Degree;
    }

    public void setDegree(Degree degree) {
        Degree = degree;
    }

}
