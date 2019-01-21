package com.okta.developer.demo.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "PatientName")
public class PatientName {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long id;
  //  private @NonNull String prefix; //คำนำหน้าชื่อ
    private @NonNull String patientName;
    //private @NonNull Long age;

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

    @ManyToOne()
    @JoinColumn(name = "suggestionId")
    private Suggestion suggestion;

    public PatientName(){}
    public PatientName(String patientName){
        this.patientName = patientName;
        Prefix prefix = new Prefix();
        Hospital hospital = new Hospital();
        Symptom symptom = new Symptom();
        Treatment treatment = new Treatment();
    }
}