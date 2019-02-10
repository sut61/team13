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
import javax.validation.constraints.*;
@Data
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @SequenceGenerator(name="Person",sequenceName="Person_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Person_seq")
    private @NonNull Long id;
    @NotNull
    private String pname;

    public Person(){
    }
    public Person(String pname){
        this.pname = pname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}