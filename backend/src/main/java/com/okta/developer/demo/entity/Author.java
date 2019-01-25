package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@ToString
@EqualsAndHashCode
@Table(name="Author") //ชื่อตาราง
public class Author {

    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="author_seq",sequenceName="author_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="author_seq")     // Annotations Generate id เอง ตอน insert
    
    private  Long Id;
    private  String authorname;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname){
        this.authorname = authorname;
    }

 
    public Author(){}

	public void setAuthor(long author2) {
	}
}