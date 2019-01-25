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
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
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
                           ProfessorReporitory professorReporitory, StudentReporitory studentReporitory,GpaRepository gpaRepository ,
                           DegreeRepository degreeRepository , EducationRepository educationRepository , GenderRepository genderRepository,
                           PersonnalRepository personnalRepository , PositionRepository positionRepository , ReligionRepository religionRepository,
    UserRepository userRepository,NationalityRepository nationalityRepository) {
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



            Degree d1 =new Degree();
            d1.setDegree("เชี่ยวชาญพิเศษ");
            Degree d2 =new Degree();
            d2.setDegree("เชี่ยวชาญ");
            Degree d3 =new Degree();
            d3.setDegree("ชำนาญการพิเศษ");
            Degree d4 =new Degree();
            d4.setDegree("ชำนาญการ");
            Degree d5 =new Degree();
            d5.setDegree("คุณครู");
            Degree d6 =new Degree();
            d6.setDegree("คุณครผู้ช่วย");
            Degree d7 =new Degree();
            d7.setDegree("คุณครูอัตราจ้าง");
            Degree d8 =new Degree();
            d8.setDegree("พนักงานราชการ");

            degreeRepository.save(d1);
            degreeRepository.save(d2);
            degreeRepository.save(d3);
            degreeRepository.save(d4);
            degreeRepository.save(d5);
            degreeRepository.save(d6);
            degreeRepository.save(d7);
            degreeRepository.save(d8);


            Education e1 = new Education();
            e1.setEducation("ปริญญาเอก");
            Education e2 = new Education();
            e2.setEducation("ปริญญาโท");
            Education e3 = new Education();
            e3.setEducation("ปริญญาตรี");
            Education e4 = new Education();
            e4.setEducation("ปวส.");
            Education e5 = new Education();
            e5.setEducation("ปวช.");
            Education e6 = new Education();
            e6.setEducation("มัธยมปลาย");
            Education e7 = new Education();
            e7.setEducation("มัธยมต้น");

            educationRepository.save(e1);
            educationRepository.save(e2);
            educationRepository.save(e3);
            educationRepository.save(e4);
            educationRepository.save(e5);
            educationRepository.save(e6);
            educationRepository.save(e7);


            Position p1 = new Position();
            p1.setPosition("ผู้อำนวยการ");
            Position p2 = new Position();
            p2.setPosition("รองผู้อำนวยการ");
            Position p3 = new Position();
            p3.setPosition("คุณครู");
            Position p4 = new Position();
            p4.setPosition("พนักงานราชการ");

            positionRepository.save(p1);
            positionRepository.save(p2);
            positionRepository.save(p3);
            positionRepository.save(p4);


            Genders gd1 = new Genders();
            gd1.setGenders("นาย");
            Genders gd2 = new Genders();
            gd2.setGenders("นาง");
            Genders gd3 = new Genders();
            gd3.setGenders("นางสาว");
            Genders gd4 = new Genders();
            gd4.setGenders("เด็กชาย");
            Genders gd5 = new Genders();
            gd5.setGenders("เด็กหญิง");
            genderRepository.save(gd1);
            genderRepository.save(gd2);
            genderRepository.save(gd3);
            genderRepository.save(gd4);
            genderRepository.save(gd5);

            Religion r1 = new Religion();
            r1.setReligion("พุทธ");
            Religion r2 = new Religion();
            r2.setReligion("คริสต์");
            Religion r3 = new Religion();
            r3.setReligion("อิสลาม");
            Religion r4 = new Religion();
            r4.setReligion("พราหมณ์-ฮินดู");

            User user = new User("admin","1234","1234","111");
            userRepository.save(user);
            User user1 = new User("jirasak","0848254341","1235","112");
            userRepository.save(user1);
            User user2 = new User("B5908851","02012541","1245","113");
            userRepository.save(user2);


            religionRepository.save(r1);
            religionRepository.save(r2);
            religionRepository.save(r3);
            religionRepository.save(r4);
            userRepository.findAll().forEach(System.out::println);
            genderRepository.findAll().forEach(System.out::println);

            Nationality n1 = new Nationality();
            n1.setNation("ไทย");
            Nationality n2 = new Nationality();
            n2.setNation("กัมพูชา");
            Nationality n3 = new Nationality();
            n3.setNation("ลาว");
            Nationality n4 = new Nationality();
            n4.setNation("เวียดนาม");

            nationalityRepository.save(n1);
            nationalityRepository.save(n2);
            nationalityRepository.save(n3);
            nationalityRepository.save(n4);
            nationalityRepository.findAll().forEach(System.out::println);

        };
	}
}
