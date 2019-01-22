package com.okta.developer.demo.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Collection;
import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table(name="major")
public class Major {
    @Id
    @SequenceGenerator(name="major_seq",sequenceName="major_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="major_seq")
    @Column(name="major_ID",unique = true, nullable = true)
    private @NonNull Long major_id;

    public Long getMajor_id() {
        return major_id;
    }

    public void setMajor_id(Long major_id) {
        this.major_id = major_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    private @NonNull String major_name;

    public Major(String major_name){

        this.major_name = major_name ;
    }
    public Major(){

        ;
    }


}
