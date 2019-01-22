package com.okta.developer.demo;

import org.springframework.boot.ApplicationRunner;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import com.okta.developer.demo.entity.Symptom;
import com.okta.developer.demo.entity.Hospital;
import com.okta.developer.demo.entity.PatientName;
import com.okta.developer.demo.entity.Prefix;
import com.okta.developer.demo.entity.Treatment;
import com.okta.developer.demo.repository.HospitalRepository;
import com.okta.developer.demo.repository.SymptomRepository;
import com.okta.developer.demo.repository.PatientNameRepository;
import com.okta.developer.demo.repository.TreatmentRepository;
import com.okta.developer.demo.repository.PrefixRepository;

@Component
public class HospitalRoomDataLoader implements ApplicationRunner {
    @Autowired HospitalRepository hospitalRepository;
    @Autowired SymptomRepository symptomRepository;
    @Autowired PatientNameRepository patientNameRepository ;
    @Autowired TreatmentRepository treatmentRepository;
    @Autowired PrefixRepository prefixRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Stream.of("เด็กชาย","เด็กหญิง","นาย","นาง","นางสาว").forEach(prefix -> {
            prefixRepository.save(new Prefix(prefix));
        });
        prefixRepository.findAll().forEach(System.out::println);
        

        Stream.of("มีไข้","ปวดหัว","ท้องเสีย","เป็นแผล").forEach(symptom -> {
            symptomRepository.save(new Symptom(symptom));
        });
        symptomRepository.findAll().forEach(System.out::println);

        Stream.of("ทำแผล","ทายา","นอนพักในห้องพยาบาล","ให้ยาตามอาการ").forEach(treatment -> {
            treatmentRepository.save(new Treatment(treatment));
        });
        treatmentRepository.findAll().forEach(System.out::println);

        Stream.of("-","โรงพยาบาลมหาวิทยาลัยเทคโนโลยีสุรนารี").forEach(hospital -> {
            hospitalRepository.save(new Hospital(hospital));
        });
        hospitalRepository.findAll().forEach(System.out::println);
	}
    
}