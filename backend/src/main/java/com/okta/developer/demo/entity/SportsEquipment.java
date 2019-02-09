package com.okta.developer.demo.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "SportsEquipment")

public class SportsEquipment {
    @Id
    @SequenceGenerator(name="sem_seq",sequenceName="sem_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="sem_seq")

    private @NonNull Long SportE_id;
    private @NonNull String SportsE ;

    public Long getSportE_id() {
        return SportE_id;
    }

    public void setSportE_id(Long sportE_id) {
        this.SportE_id = sportE_id;
    }

    public String getSportsE() {
        return SportsE;
    }

    public void setSportsE(String sportsE) {
        this.SportsE = sportsE;
    }
    public SportsEquipment (){}
}
