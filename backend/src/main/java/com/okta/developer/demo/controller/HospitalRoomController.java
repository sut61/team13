package com.okta.developer.demo.controller;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okta.developer.demo.entity.Hospital;
import com.okta.developer.demo.entity.PatientName;
import com.okta.developer.demo.entity.Suggestion;
import com.okta.developer.demo.entity.Symptom;
import com.okta.developer.demo.entity.Treatment;
import com.okta.developer.demo.repository.HospitalRepository;
import com.okta.developer.demo.repository.PatientNameRepository;
import com.okta.developer.demo.repository.SuggestionRepository;
import com.okta.developer.demo.repository.SymptomRepository;
import com.okta.developer.demo.repository.TreatmentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalRoomController{
    @Autowired private HospitalRepository hospitalRepository;
    @Autowired private PatientNameRepository patientNameRepository;
    @Autowired private SuggestionRepository suggestionRepository;
    @Autowired private SymptomRepository symptomRepository;
    @Autowired private TreatmentRepository treatmentRepository;

    @GetMapping("/PatientName")
    public Collection<PatientName> patientName(){
        return patientNameRepository.findAll();
    }

    @GetMapping("/PatientName/{dataID}")
    public Optional<PatientName> takeinPatientNameByid(@PathVariable Long dataID ){
        return patientNameRepository.findById(dataID);
    }

    @PostMapping("/PatientName/addPatientName")
    public PatientName newPatientName(PatientName newPatientName,@RequestBody() Map<String,Object> body) {
        Optional<Hospital> hospital = hospitalRepository.findById(Long.valueOf(body.get("referral").toString()));
        Optional<Suggestion> suggestion = suggestionRepository.findById(Long.valueOf(body.get("suggestion").toString()));
        Optional<Symptom> symptom = symptomRepository.findById(Long.valueOf(body.get("symptom").toString()));
        Optional<Treatment> treatment = treatmentRepository.findById(Long.valueOf(body.get("treatment").toString()));

        newPatientName.setHospital(hospital.get());
        newPatientName.setSuggestion(suggestion.get());
        newPatientName.setSymptom(symptom.get());
        newPatientName.setTreatment(treatment.get());

        //newPatientName.setPatientName(body.get("prefix").toString());
        newPatientName.setPatientName(body.get("patientName").toString());

        return patientNameRepository.save(newPatientName);
    }
    

    //=============Hospital====================
    @GetMapping("/Hospital")
    public Collection<Hospital> hospital(){
        return hospitalRepository.findAll();
    }
    
    @GetMapping("/Hospital/{hospitalID}")
    public Optional<Hospital> takeinUserByid(@PathVariable Long hospitalID ){
        return hospitalRepository.findById(hospitalID);
    }
    @PostMapping("/Hospital/addHospital/{referral}")
    public Hospital newHospital(@PathVariable String referral){
        Hospital newHospital = new Hospital(referral); 
        return hospitalRepository.save(newHospital); 
    }

    //=============Suggestion====================

    //===============Symptom=====================

    //==============Treatment====================
}
