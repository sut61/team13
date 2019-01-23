package com.okta.developer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	@Autowired HospitalRepository hospitalRepository;
    @Autowired SymptomRepository symptomRepository;
    @Autowired PatientNameRepository patientNameRepository ;
    @Autowired TreatmentRepository treatmentRepository;
	@Autowired PrefixRepository prefixRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(PrefixRepository prefixRepository, SymptomRepository symptomRepository,
	TreatmentRepository treatmentRepository, HospitalRepository hospitalRepository) {
		return args -> {
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
		};		
	}
}
