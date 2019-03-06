package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.Date;
import java.sql.Time;

@Entity
@Table(name = "Applicant")
public class Applicant{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long applicantId;

    @NotNull(message="apllicantName must not be null to be valid")
    @Size(min = 5)
    @Size(max = 20)
    private String applicantName; //ชื่อผู้ขอใช้บริการ

    @ManyToOne()
    private Prefix prefix;

    @ManyToOne()
    private Activity activity;

    @ManyToOne()
    private MediaRoom mediaRoom;

    @ManyToOne()
    private Level level;

    @ManyToOne()
    private Equipment equipment;

    public Applicant() {}

    public Long getApplicantId() {
        return applicantId;
    }
    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Prefix getPrefix() {
        return prefix;
    }
    public void setPrefix(Prefix prefix) {
        this.prefix = prefix;
    }

    public Activity getActivity() {
        return activity;
    }
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public MediaRoom getMediaRoom(){
        return mediaRoom;
    }

    public void setMediaRoom(MediaRoom mediaRoom) {
        this.mediaRoom = mediaRoom;
    }

    public Level getLevel(){
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public Equipment getEquipment(){
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
