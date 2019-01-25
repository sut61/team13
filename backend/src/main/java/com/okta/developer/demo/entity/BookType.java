package com.okta.developer.demo.entity;
import lombok.EqualsAndHashCode;
import lombok.*;
import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@ToString
@EqualsAndHashCode
@Table(name="BookType") //ชื่อตาราง
public class BookType {

    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="bookType_seq",sequenceName="bookType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bookType_seq")     // Annotations Generate id เอง ตอน insert

    private  Long Id;
    private  String bookType;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public BookType(){}

	public void setBooktype(BookType booktype2) {
	}

	public void setBookType(long booktype2) {
	}
}