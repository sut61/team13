package com.okta.developer.demo.entity;
import lombok.*;
import javax.persistence.*;
import javax.persistence.FetchType;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Table (name = "Position")
public class Position {



    @Id
    @SequenceGenerator(name="po",sequenceName="po")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="po")
    private @NonNull long position_id;
    private @NonNull String  position;


    public Position(){

    }
    public Position(long position_id,String  position){
            this.position_id = position_id;
            this.position = position;


    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

}


