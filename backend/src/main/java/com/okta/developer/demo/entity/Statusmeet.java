package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "Statusmeet")
public class Statusmeet{
    @Id
    @SequenceGenerator(name="Statusmeet",sequenceName="Statusmeet_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Statusmeet_seq")
    private @NonNull Long id;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Statusmeet(){}
    public Statusmeet(String status){
        this.status = status;
    }
}