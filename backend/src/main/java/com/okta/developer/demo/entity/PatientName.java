package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Getter @Setter
@Table(name = "PatientName")
public class PatientName {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long id;

    @NotNull(message="patient name must not be null to be valid")
    private String patientName;
    @NotNull(message="suggesttion must not be null to be valid")
    private String suggestion;

    @ManyToOne()
    @JoinColumn(name = "prefixId")
    private Prefix prefix;

    @ManyToOne()
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @ManyToOne()
    @JoinColumn(name = "symptomId")
    private Symptom symptom;

    @ManyToOne()
    @JoinColumn(name = "treatmentId")
    private Treatment treatment;

    public PatientName(){}
    public PatientName(String patientName, String suggestion){
        Prefix prefix = new Prefix();
        Hospital hospital = new Hospital();
        Symptom symptom = new Symptom();
        Treatment treatment = new Treatment();
        this.patientName = patientName;
        this.suggestion = suggestion;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getPatientName(){
        return patientName;
    }
    public void setSuggestion(String suggestion){
        this.suggestion = suggestion;
    }
    public String getSuggestion(){
        return suggestion;
    }
}
