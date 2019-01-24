package com.okta.developer.demo.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "Genders")
public class Genders {


    @Id
    @SequenceGenerator(name="gen",sequenceName="gen")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
    private @NonNull
    long gender_id;
    private @NonNull
    String gender;

    public Genders() {
    }

    public Genders(long gender_id, String  gender) {
        this.gender_id = gender_id;
        this.gender = gender;

    }

    public void setGenders(String gender) {
        this.gender = gender;
    }

    public String getGenders() {
        return gender;
    }
}
