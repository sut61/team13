package com.okta.developer.demo.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.mapping.Collection;
import javax.validation.constraints.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="professor")
public class Professor {


    @Id
    @SequenceGenerator(name="professor_seq",sequenceName="professor_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="professor_seq")
    @Column(name = "PROFESSOR_ID", unique = true, nullable = true)
    private @NonNull Long professor_id;
    @NotNull
    private String professor_name;

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }





    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    public String getProfessor_name() {
        return professor_name;
    }
}
