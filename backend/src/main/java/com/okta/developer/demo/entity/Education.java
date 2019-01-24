package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "Education")
public class Education {

    public long getEducation_id() {
        return Education_id;
    }

    public void setEducation_id(long education_id) {
        Education_id = education_id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Education(){}

    @Id
    @SequenceGenerator(name="educa",sequenceName="educa")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="educa")
    private @NonNull long Education_id;
    private @NonNull String education ;

}
