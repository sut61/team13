package com.okta.developer.demo.entity;
import lombok.*;
import javax.validation.constraints.*;
import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Table(name="Parent")
public class Parents {
    @Id
    @SequenceGenerator(name="parents_seq",sequenceName="parents_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="parents_seq")
    private @NonNull Long id;
    @NotNull
    private  String name;
    public Parents(){}
    public Parents(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
