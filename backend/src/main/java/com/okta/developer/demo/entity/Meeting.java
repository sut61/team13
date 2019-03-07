package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.*;
@Entity
@ToString
@EqualsAndHashCode
public class Meeting {
    @Id
    @SequenceGenerator(name="Meeting_seq",sequenceName="Meeting_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Meeting_seq")
    private @NonNull Long id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 5)
    @Size(max =20)
    @Column(unique = true)
    private String topic;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min = 5)
    @Size(max =20)
    @Column(unique = true)
    private String descrip;
    public Date day;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @ManyToOne
    private Category category;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Statusmeet statusmeet;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Statusmeet getStatusmeet() {
        return statusmeet;
    }

    public void setStatusmeet(Statusmeet statusmeet) {
        this.statusmeet = statusmeet;
    }

    public Meeting(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Meeting(String topic){
        this.topic = topic;
    }


}