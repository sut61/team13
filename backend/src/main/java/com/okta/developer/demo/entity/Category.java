package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @SequenceGenerator(name="Category_seq",sequenceName="Category_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Category_seq")
    private @NonNull Long id;
    private String catename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public Category(){

    }public Category(String catename){
        this.catename = catename;

    }

}