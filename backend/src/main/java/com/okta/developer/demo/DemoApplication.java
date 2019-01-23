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
	TreatmentRepository treatmentRepository, HospitalRepository hospitalRepository,GradeReporitory gradeReporitory, MajorReporitory majorReporitory,
                           ProfessorReporitory professorReporitory, StudentReporitory studentReporitory,
                           GpaRepository gpaRepository) {
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

            Gpa g1 = new Gpa();
            Gpa g2 = new Gpa();
            Gpa g3 = new Gpa();
            Gpa g4 = new Gpa();
            Gpa g5 = new Gpa();
            Gpa g6 = new Gpa();
            Gpa g7 = new Gpa();
            Gpa g8 = new Gpa();
            g1.setGgpa("0.00");
            g2.setGgpa("1.00");
            g3.setGgpa("1.50");
            g4.setGgpa("2.00");
            g5.setGgpa("2.50");
            g6.setGgpa("3.00");
            g7.setGgpa("3.50");
            g8.setGgpa("4.00");
            gpaRepository.save(g1);
            gpaRepository.save(g2);
            gpaRepository.save(g3);
            gpaRepository.save(g4);
            gpaRepository.save(g5);
            gpaRepository.save(g6);
            gpaRepository.save(g7);
            gpaRepository.save(g8);
            Stream.of("Tanapon", "Sitthichai", "Somchai", "Nanti").forEach(StudentName -> {
                Student student = new Student();
                student.setStudent_name(StudentName);
                studentReporitory.save(student);
            });
            Stream.of("Somsri","Wanpen","Siripond","Noppong").forEach(professorName -> {
                Professor professor = new Professor();
                professor.setProfessor_name(professorName);
                professorReporitory.save(professor);

            });



            Major major1 = new Major("Mathematics");
            Major major2 = new Major("Art");
            Major major3 = new Major("Computer");
            Major major4 = new Major("Science");
            Major major5 = new Major("Social");
            Major major6 = new Major("Thai Language");
            Major major7 = new Major("English Language");
            Major major8 = new Major("Music");
            majorReporitory.save(major1);
            majorReporitory.save(major2);
            majorReporitory.save(major3);
            majorReporitory.save(major4);
            majorReporitory.save(major5);
            majorReporitory.save(major6);
            majorReporitory.save(major7);
            majorReporitory.save(major8);



            studentReporitory.findAll().forEach(System.out::println);
            gradeReporitory.findAll().forEach(System.out::println);
            professorReporitory.findAll().forEach(System.out::println);
            majorReporitory.findAll().forEach(System.out::println);
		};
	}
}
