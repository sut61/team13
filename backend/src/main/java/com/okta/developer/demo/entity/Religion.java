package com.okta.developer.demo.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "Religion")
public class Religion {



    @Id
    @SequenceGenerator(name="re",sequenceName="re")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="re")

    private @NonNull long id;
    private @NonNull String  religion;


    public Religion(){

    }
    public Religion(long religion_id,String  religion,String  extraction,String nationality){
        this.id =religion_id;
        this.religion=religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getReligion() {
        return religion;
    }
}
