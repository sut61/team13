package com.okta.developer.demo.entity;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import lombok.*;


@Entity
@Data
@EqualsAndHashCode
@Table(name="book")

public class Book {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private   Long Id;
    private   String name;
    private   String quantity;
   
    @ManyToOne
    private Bookcase bookcase;
    @ManyToOne
    private BookType booktype;
    @ManyToOne
    private Author author;
   

    public Book(){    }

    public Book(String name, String quantity, Bookcase bookcase, BookType booktype, Author author) {
        this.name = name;
        this.quantity = quantity;
        this.bookcase = bookcase;
        this.booktype = booktype;
        this.author = author;
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BookType getBooktype() {
        return booktype;
    }

    public void setBookType(BookType booktype) {
        this.booktype = booktype;
    }

    public Bookcase getBookcase() {
        return bookcase;
    }

    public void setBookcase(Bookcase bookcase) {
        this.bookcase = bookcase;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}

