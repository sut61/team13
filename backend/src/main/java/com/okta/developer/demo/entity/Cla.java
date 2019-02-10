package com.okta.developer.demo.entity;



import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "Cla")
public class Cla {

    @Id
    @SequenceGenerator(name = "cla_seq", sequenceName = "cla_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cla_seq")
    private @NonNull Long id;
    @NotNull
    private String cla;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
}

