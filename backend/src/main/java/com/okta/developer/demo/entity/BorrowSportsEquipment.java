package com.okta.developer.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@ToString
@EqualsAndHashCode
public class BorrowSportsEquipment {

    @Id
    @SequenceGenerator(name="bsem_seq",sequenceName="bsem_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bsem_seq")
    private   @NonNull Long id;
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 5 ,max = 20)
    @Column(unique = true)
    private    String name_borrow;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 5 ,max = 20)
    private    String name_lender;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date day_borrow;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date day_return;

    @ManyToOne
    private SportsEquipment sportsequipment ;

    @ManyToOne
    private Classrooms classrooms;


    @ManyToOne
    private Piece piece;

    public Long getIid() {
        return id;
    }

    public void setId(Long bse_id) {
        this.id = id;
    }

    public String getName_borrow() {
        return name_borrow;
    }

    public void setName_borrow(String name_borrow) {
        this.name_borrow = name_borrow;
    }

    public String getName_lender() {
        return name_lender;
    }

    public void setName_lender(String name_lender) {
        this.name_lender = name_lender;
    }

    public Date getDay_borrow() {
        return day_borrow;
    }

    public void setDay_borrow(Date day_borrow) {
        this.day_borrow = day_borrow;
    }

    public Date getDay_return() {
        return day_return;
    }

    public void setDay_return(Date day_return) {
        this.day_return = day_return;
    }

    public SportsEquipment getSportsequipment() {
        return sportsequipment;
    }

    public void setSportsequipment(SportsEquipment sportsequipment) {
        this.sportsequipment = sportsequipment;
    }

    public Classrooms getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Classrooms classrooms) {
        this.classrooms = classrooms;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public BorrowSportsEquipment(){}
}
