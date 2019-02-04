package com.okta.developer.demo.entity;

import lombok.*;


import javax.persistence.*;


@Entity
@Data
@ToString
@EqualsAndHashCode
@Table(name="status")

public class Status {

    @Id
    @SequenceGenerator(name="status_seq",sequenceName="status_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status_seq")
    @Column(name="STATUS_ID",unique = true, nullable = true)
    private @NonNull Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStstusname() {
        return ststusname;
    }

    public void setStstusname(String ststusname) {
        this.ststusname = ststusname;
    }

    private @NonNull String ststusname;

    public Status (){}
    public Status (String ststusname){
        this.ststusname = ststusname;
    }

}
