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
@Table(name = "Activity")
public class Activity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long activityId;
    @NotNull(message="String must not be null to be valid")
    @Size(min = 5)
    @Size(max = 20)
    private String activity;

    public Activity(){}
    
    public Activity(String activity){
        this.activity = activity;
    }
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
