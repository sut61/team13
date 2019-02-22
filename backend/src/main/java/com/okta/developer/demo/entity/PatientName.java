package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Getter @Setter
@Table(name = "PatientName")
public class PatientName {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long id;

    @NotNull(message="patient name must not be null to be valid")
    //@Pattern(regexp = "")
    @Size(min = 5 ,max = 20)
    private String patientName;

    @NotNull(message="suggesttion must not be null to be valid")
    //@Pattern(regexp = "([ก-ฮ])\\w+")
    @Size(min = 5 ,max = 30)
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
    public void setHospital(Hospital hospital){
        this.hospital = hospital;
    }
    public Hospital getHospital(){
        return hospital;
    }
    public void setPrefix(Prefix prefix){
        this.prefix = prefix;
    }
    public Prefix getPrefix(){
        return prefix;
    }
    public void setSymptom(Symptom symptom){
        this.symptom = symptom;
    }
    public Symptom getSymptom(){
        return symptom;
    }
    public void setTreatment(Treatment treatment){
        this.treatment = treatment;
    }
    public Treatment getTreatment(){
        return treatment;
    }
}
