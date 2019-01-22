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
import com.okta.developer.demo.entity.Symptom;
import com.okta.developer.demo.entity.Treatment;
import com.okta.developer.demo.entity.Prefix;
import com.okta.developer.demo.repository.HospitalRepository;
import com.okta.developer.demo.repository.PatientNameRepository;
import com.okta.developer.demo.repository.SymptomRepository;
import com.okta.developer.demo.repository.TreatmentRepository;
import com.okta.developer.demo.repository.PrefixRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalRoomController{
    @Autowired private HospitalRepository hospitalRepository;
    @Autowired private PatientNameRepository patientNameRepository;
    @Autowired private SymptomRepository symptomRepository;
    @Autowired private TreatmentRepository treatmentRepository;
    @Autowired private PrefixRepository prefixRepository;

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
        Optional<Prefix> prefix = prefixRepository.findById(Long.valueOf(body.get("prefix").toString()));
        Optional<Symptom> symptom = symptomRepository.findById(Long.valueOf(body.get("symptom").toString()));
        Optional<Treatment> treatment = treatmentRepository.findById(Long.valueOf(body.get("treatment").toString()));
        Optional<Hospital> hospital = hospitalRepository.findById(Long.valueOf(body.get("hospital").toString()));
       
        
        newPatientName.setHospital(hospital.get());
        newPatientName.setSymptom(symptom.get());
        newPatientName.setTreatment(treatment.get());
        newPatientName.setPrefix(prefix.get());
        newPatientName.setPatientName(body.get("patientName").toString());
        newPatientName.setSuggestion(body.get("suggestion").toString());
        return patientNameRepository.save(newPatientName);
    }
    //=============Hospital====================
    @GetMapping("/Hospital")
    public Collection<Hospital> hospital(){
        return hospitalRepository.findAll();
    }
    @GetMapping("/Hospital/{hospitalID}")
    public Optional<Hospital> takeinHospitalByid(@PathVariable Long hospitalID ){
        return hospitalRepository.findById(hospitalID);
    }
    @PostMapping("/Hospital/addHospital/{hospital}")
    public Hospital newHospital(@PathVariable String hospital){
        Hospital newHospital = new Hospital(hospital); 
        return hospitalRepository.save(newHospital); 
    }

    
   //===============Symptom=====================
    @GetMapping("/Symptom")
    public Collection<Symptom> symptom(){
        return symptomRepository.findAll();
    }
    @GetMapping("/Symptom/{symptomID}")
    public Optional<Symptom> takeinSymptomByid(@PathVariable Long symptomID ){
        return symptomRepository.findById(symptomID);
    }
    @PostMapping("/Symptom/addSymptom/{symptom}")
    public Symptom newSymptom(@PathVariable String symptom){
        Symptom newSymptom = new Symptom(symptom); 
        return symptomRepository.save(newSymptom); 
    }
    //==============Treatment====================
    @GetMapping("/Treatment")
    public Collection<Treatment> treatment(){
        return treatmentRepository.findAll();
    }
    @GetMapping("/Treatment/{treatmentID}")
    public Optional<Treatment> takeinTreatmentByid(@PathVariable Long treatmentID ){
        return treatmentRepository.findById(treatmentID);
    }
    @PostMapping("/Treatment/addTreatment/{treatment}")
    public Treatment newTreatment(@PathVariable String symptom){
        Treatment newTreatment = new Treatment(symptom); 
        return treatmentRepository.save(newTreatment); 
    }
    //==============Prefix====================
    @GetMapping("/Prefix")
    public Collection<Prefix> prefix(){
        return prefixRepository.findAll();
    }
    @GetMapping("/Prefix/{prefixID}")
    public Optional<Prefix> takeinPrefixByid(@PathVariable Long prefixID ){
        return prefixRepository.findById(prefixID);
    }
    @PostMapping("/Prefix/addPrefix/{prefix}")
    public Prefix newPrefix(@PathVariable String prefix){
        Prefix newPrefix = new Prefix(prefix); 
        return prefixRepository.save(newPrefix); 
    }
}
