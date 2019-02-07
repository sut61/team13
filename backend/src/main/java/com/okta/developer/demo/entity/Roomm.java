package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Roomm")
public class Roomm {
    @Id
    @SequenceGenerator(name="roo_seq",sequenceName="roo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="roo_seq")
    private @NonNull Long id;

    private String roomm ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomm() {
        return roomm;
    }

    public void setRoomm(String roomm) {
        this.roomm = roomm;
    }


    public Roomm(){}

}
