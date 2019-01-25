package com.okta.developer.demo.entity;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "Personnel")
public class Personnel {
    @Id
    @SequenceGenerator(name="Personnel_seq",sequenceName="Personnel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Personnel_seq")
    @Column(name="Personnel_ID",unique = true, nullable = true)
    private @NonNull Long id_teacher;
    private @NonNull String fname;
    private @NonNull String Lname;
    private @NonNull String Birthday;
    private @NonNull String educational;
    private @NonNull String Firstday_of_work;
    private @NonNull String Lastday_of_work;
    private @NonNull String phonenumber;
    private @NonNull String E_mail;
    private @NonNull String Identification_number;
    public Personnel(){}
    public Personnel(String fname,String Lname,String Birthday,String
            educationalString,String Firstday_of_work,String Lastday_of_work,String
                             phonenumber,String E_mail,String Identification_number){
        this.fname = fname;
        this.Lname = Lname;
        this.Birthday = Birthday;
        this.educational = educationalString;
        this.Firstday_of_work = Firstday_of_work;
        this.Lastday_of_work = Lastday_of_work;
        this.phonenumber = phonenumber;
        this.Identification_number = E_mail;
        this.E_mail = Identification_number;
    }
}