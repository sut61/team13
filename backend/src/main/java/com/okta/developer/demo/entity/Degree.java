package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "Degrees")
public class Degree {



    @Id
    @SequenceGenerator(name="degree",sequenceName="degree")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="degree")
    private @NonNull long Degree_id;
    private @NonNull String degree ;
    public long getDegree_id() {
        return Degree_id;
    }

    public void setDegree_id(long degree_id) {
        Degree_id = degree_id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public Degree(){}
}
