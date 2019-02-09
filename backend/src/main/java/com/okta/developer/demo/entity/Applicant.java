package com.okta.developer.demo.entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name = "Applicant")
public class Applicant{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long applicantId;

    @NotNull(message="apllicantName must not be null to be valid")
    private String applicantName; //ชื่อผู้ขอใช้บริการ
    
    private @NonNull String time;
    
    private @NonNull String date;

    

    @ManyToOne()
    private Prefix prefix;

    @ManyToOne()
    private Activity activity;

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

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
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

}