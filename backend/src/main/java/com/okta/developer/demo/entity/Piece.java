package com.okta.developer.demo.entity;

import lombok.*;

import javax.persistence.*;
@Entity
public class Piece {
    @Id
    @SequenceGenerator(name="pi_seq",sequenceName="pi_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pi_seq")

   @NonNull
    private Long p_id;

    @NonNull
    private String piece;

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
    public Piece(){}
    public Piece(String piece){
        this.piece=piece;    }
}
