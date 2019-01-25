package com.okta.developer.demo.entity;
import lombok.EqualsAndHashCode;
import lombok.*;
import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@ToString
@EqualsAndHashCode
@Table(name="Bookcase") //ชื่อตาราง
public class Bookcase {

    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="bookcase_seq",sequenceName="bookcase_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bookcase_seq")     // Annotations Generate id เอง ตอน insert

    private  Long Id;
    private  String bookcase;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBookcase() {
        return bookcase;
    }

    public void setBookcase(String bookcase) {
        this.bookcase = bookcase;
    }

    public Bookcase(){}

	public void setBookcase(long bookcase2) {
	}

}