package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "Level")

public class Level {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long levelId;
    @NotNull(message="String must not be null to be valid")
    @Size(min = 5 ,max = 20)
    private String level;

    public Level(){}

    public Level(String level){
        this.level = level;
    }
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

}
