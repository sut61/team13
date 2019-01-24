package com.demo.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "Gender")
public class Gender {


    @Id
    @SequenceGenerator(name="gen",sequenceName="gen")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
    private @NonNull
    long gender_id;
    private @NonNull
    String gender;

    public Gender() {
    }

    public Gender(long gender_id, String  gender) {
        this.gender_id = gender_id;
        this.gender = gender;

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
