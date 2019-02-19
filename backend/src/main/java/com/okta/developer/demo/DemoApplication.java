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
    @Autowired ActivityRepository activityRepository;
    @Autowired MediaRoomRepository mediaRoomRepository;
    @Autowired
	private BooksRepository bookrepository ;

	@Autowired
	private BookTypeRepository booktyperepository ;

	@Autowired
	private BookcaseRepository bookcaserepository ;

	@Autowired
    private AuthorRepository authorrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(PrefixRepository prefixRepository, SymptomRepository symptomRepository,
	TreatmentRepository treatmentRepository, HospitalRepository hospitalRepository,GradeReporitory gradeReporitory, MajorReporitory majorReporitory,
                           ProfessorReporitory professorReporitory, StudentReporitory studentReporitory,GpaRepository gpaRepository ,
                           DegreeRepository degreeRepository , EducationRepository educationRepository , GenderRepository genderRepository,
                           PersonnalRepository personnalRepository , PositionRepository positionRepository , ReligionRepository religionRepository,RoomRepository RoomRepository, StudyTimeTableRepository studyTimeTableRepository,
    UserRepository userRepository,NationalityRepository nationalityRepository,PersonnelRepository personnelRepository,
    BooksRepository bookRepository, BookTypeRepository bookTypeRepository,BookcaseRepository bookcaseRepository, AuthorRepository authorRepository,ClassroomsRepository classroomsRepository,ParentsRepository parentsRepository,SchoolCheckRepository schoolCheckRepository,StatusRepository statusRepository,
                           PracticeRepository practiceRepository,ClaRepository claRepository,RoommRepository roommRepository,BuildingRepository buildingRepository,ActivityRepository activityRepository,
                           SportsEquipmentRepository sportsEquipmentRepository,PieceRepository pieceRepository,BorrowSportsEquipmentRepository borrowSportsEquipmentRepository,
                           MeetingRepository meetingRepository, CategoryRepository categoryRepository,
                           PersonRepository personRepository, StatusmeetRepository statusmeetRepository,MediaRoomRepository mediaRoomRepository) {
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
        
        Stream.of("ทำกิจกรรมกลุ่ม","ดูสารคดี","อื่นๆ").forEach(activity -> {
            activityRepository.save(new Activity(activity));
        });
        Stream.of("ห้อง Media 1","ห้อง Media 2","ห้อง Media 3").forEach(mediaRoom -> {
            mediaRoomRepository.save(new MediaRoom(mediaRoom));
        });

		activityRepository.findAll().forEach(System.out::println);

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
            Student stu = new Student();
            Student stu1 = new Student();
            Student stu2 = new Student();
            Student stu3 = new Student();
            Student stu4 = new Student();
            Student stu5 = new Student();
            stu.setStudent_name("Tanapon");
            stu1.setStudent_name("Sitthichai");
            stu2.setStudent_name("Somchai");
            stu3.setStudent_name("Nanti");
            stu4.setStudent_name("Jiraphat");
            stu5.setStudent_name("Thiti");
            studentReporitory.save(stu);
            studentReporitory.save(stu1);
            studentReporitory.save(stu2);
            studentReporitory.save(stu3);
            studentReporitory.save(stu4);
            studentReporitory.save(stu5);

            Stream.of("Somsri","Wanpen","Siripond","Noppong").forEach(professorName -> {
                Professor professor = new Professor();
                professor.setProfessor_name(professorName);
                professorReporitory.save(professor);

            });



            Major major1 = new Major("Mathematics");
            Major major2 = new Major("Artist");
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



            Personnal per = new Personnal();
            per.setFname("Chutimon");
            per.setLname("Wongsa");
            per.setJob_id("B5908851");
            per.setIdentificationNumber("1199900642331");
            per.setPhonenumber("0990589313");
            personnalRepository.save(per);
            personnalRepository.save(per);
            personnalRepository.save(per);
            personnalRepository.save(per);
            personnalRepository.save(per);
            personnalRepository.findAll().forEach(System.out::println);


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

            Room room = new Room("B4101");
            RoomRepository.save(room);
            Room room2 = new Room("B1202");
            RoomRepository.save(room2);
            Room room3 = new Room("B1108");
            RoomRepository.save(room3);
            Room room4 = new Room("B3032");
            RoomRepository.save(room4);


            Personnel personnel = new Personnel("1123","5645313","Prayuth","Chanocha",
                    "Po_2018@hotmail.com","Thai","B","Computer Engineering","044-856-4681");
            personnelRepository.save(personnel);
            Personnel personnel2 = new Personnel("1150","87451245","Srivoradee","Rangsriramanakul",
                    "Sri_2019@sut.com","Thai","B","Computer Engineering","044-123-1345");
            personnelRepository.save(personnel2);


            Studytimetable stt = new Studytimetable("08.00-10.00","Monday", major1,room2, personnel);
            studyTimeTableRepository.save(stt);
            Studytimetable stt2 = new Studytimetable("10.00-12.00","Friday", major2,room, personnel2);
            studyTimeTableRepository.save(stt2);
            Studytimetable stt3 = new Studytimetable("13.00-15.00","Wednesday", major3,room3, personnel2);
            studyTimeTableRepository.save(stt3);


            RoomRepository.findAll().forEach(System.out::println);
            studyTimeTableRepository.findAll().forEach(System.out::println);
            personnelRepository.findAll().forEach(System.out::println);


            Author author = new Author();
      author.setAuthorname("นายประยุทธ์");
      authorRepository.save(author);

      BookType bookType1 = new BookType();
      BookType bookType2 = new BookType();
      BookType bookType3 = new BookType();
      BookType bookType4 = new BookType();
      BookType bookType5 = new BookType();
      BookType bookType6 = new BookType();
      BookType bookType7 = new BookType();
      BookType bookType8 = new BookType();
      BookType bookType9 = new BookType();
      BookType bookType10 = new BookType();
      bookType1.setBookType("000 - Generalities");
      bookType2.setBookType("100 - Pholosophy and Psychology");
      bookType3.setBookType("200 - Religion");
      bookType4.setBookType("300 - Social Sciences");
      bookType5.setBookType("400 - Language");
      bookType6.setBookType("500 - Natural Scinces and Mathematics");
      bookType7.setBookType("600 - Technology");
      bookType8.setBookType("700 - Arts");
      bookType9.setBookType("800 - Literature");
      bookType10.setBookType("900 - Geography  and  History");
      bookTypeRepository.save(bookType1);
      bookTypeRepository.save(bookType2);
      bookTypeRepository.save(bookType3);
      bookTypeRepository.save(bookType4);
      bookTypeRepository.save(bookType5);
      bookTypeRepository.save(bookType6);
      bookTypeRepository.save(bookType7);
      bookTypeRepository.save(bookType8);
      bookTypeRepository.save(bookType9);
      bookTypeRepository.save(bookType10);

      Bookcase bookcase1 = new Bookcase();
      Bookcase bookcase2 = new Bookcase();
      Bookcase bookcase3 = new Bookcase();
      Bookcase bookcase4 = new Bookcase();
      Bookcase bookcase5 = new Bookcase();
      Bookcase bookcase6 = new Bookcase();
      Bookcase bookcase7 = new Bookcase();
      Bookcase bookcase8 = new Bookcase();
      Bookcase bookcase9 = new Bookcase();
      Bookcase bookcase10 = new Bookcase();
      bookcase1.setBookcase("BC1F1");
      bookcase2.setBookcase("BC1F2");
      bookcase3.setBookcase("BC2F1");
      bookcase4.setBookcase("BC2F2");
      bookcase5.setBookcase("BC3F1");
      bookcase6.setBookcase("BC3F2");
      bookcase7.setBookcase("BC4F1");
      bookcase8.setBookcase("BC4F2");
      bookcase9.setBookcase("BC5F1");
      bookcase10.setBookcase("BC5F2");
      bookcaseRepository.save(bookcase1);
      bookcaseRepository.save(bookcase2);
      bookcaseRepository.save(bookcase3);
      bookcaseRepository.save(bookcase4);
      bookcaseRepository.save(bookcase5);
      bookcaseRepository.save(bookcase6);
      bookcaseRepository.save(bookcase7);
      bookcaseRepository.save(bookcase8);
      bookcaseRepository.save(bookcase9);
      bookcaseRepository.save(bookcase10);

      Book book = new Book("Wukong", "นายประยุทธ์", bookcase1, bookType1, author);
      bookRepository.save(book);

            Status sta = new Status();
            Status sta1 = new Status();

            sta.setStstusname("Present");
            sta1.setStstusname("Absent");
            statusRepository.save(sta);
            statusRepository.save(sta1);

            statusRepository.findAll().forEach(System.out::println);

            Parents par = new Parents();
            Parents par1 = new Parents();
            Parents par2 = new Parents();
            par.setName("Mather");
            par1.setName("Father");
            par2.setName("Other");
            parentsRepository.save(par);
            parentsRepository.save(par1);
            parentsRepository.save(par2);
            parentsRepository.findAll().forEach(System.out::println);

            Classrooms cl = new Classrooms();
            Classrooms cl1 = new Classrooms();
            Classrooms cl2 = new Classrooms();
            Classrooms cl3 = new Classrooms();
            Classrooms cl4 = new Classrooms();
            Classrooms cl5 = new Classrooms();
            Classrooms cl6 = new Classrooms();
            Classrooms cl7 = new Classrooms();
            Classrooms cl8 = new Classrooms();
            cl.setClassroom("อนุบาล1");
            cl1.setClassroom("อนุบาล2");
            cl2.setClassroom("อนุบาล3");
            cl3.setClassroom("ป.1");
            cl4.setClassroom("ป.2");
            cl5.setClassroom("ป.3");
            cl6.setClassroom("ป.4");
            cl7.setClassroom("ป.5");
            cl8.setClassroom("ป.6");
            classroomsRepository.save(cl);
            classroomsRepository.save(cl1);
            classroomsRepository.save(cl2);
            classroomsRepository.save(cl3);
            classroomsRepository.save(cl4);
            classroomsRepository.save(cl5);
            classroomsRepository.save(cl6);
            classroomsRepository.save(cl7);
            classroomsRepository.save(cl8);
            classroomsRepository.findAll().forEach(System.out::println);

            Building bui1 = new Building();
            bui1.setBuilding("1");
            Building bui2 = new Building();
            bui2.setBuilding("2");
            Building bui3 = new Building();
            bui3.setBuilding("3");

            buildingRepository.save(bui1);
            buildingRepository.save(bui2);
            buildingRepository.save(bui3);


            Cla cla1 = new Cla();
            cla1.setCla("1");
            Cla cla2 = new Cla();
            cla2.setCla("2");
            Cla cla3 = new Cla();
            cla3.setCla("3");
            claRepository.save(cla1);
            claRepository.save(cla2);
            claRepository.save(cla3);

            Roomm roo1 = new Roomm();
            roo1.setRoomm("อนุบาล");
            Roomm roo2 = new Roomm();
            roo2.setRoomm("ป.1");
            Roomm roo3 = new Roomm();
            roo3.setRoomm("ป.2");
            Roomm roo4 = new Roomm();
            roo4.setRoomm("ป.3");
            Roomm roo5 = new Roomm();
            roo5.setRoomm("ป.4");

            roommRepository.save(roo1);
            roommRepository.save(roo2);
            roommRepository.save(roo3);
            roommRepository.save(roo4);
            roommRepository.save(roo5);


            SportsEquipment se = new SportsEquipment();
            SportsEquipment se1 = new SportsEquipment();
            SportsEquipment se2 = new SportsEquipment();
            SportsEquipment se3 = new SportsEquipment();
            SportsEquipment se4 = new SportsEquipment();
            se.setSportsE("ฟุตบอล");
            se1.setSportsE("วอลลเลย์บอล");
            se2.setSportsE("บาสเกตบอล");
            se3.setSportsE("แชร์บอล");
            se4.setSportsE("ตะกร้อ");
            sportsEquipmentRepository.save(se);
            sportsEquipmentRepository.save(se1);
            sportsEquipmentRepository.save(se2);
            sportsEquipmentRepository.save(se3);
            sportsEquipmentRepository.save(se4);
            sportsEquipmentRepository.findAll().forEach(System.out::println);

            Piece pn = new Piece();
            Piece pn1 = new Piece();
            Piece pn2 = new Piece();
            Piece pn3 = new Piece();
            Piece pn4 = new Piece();
            pn.setPiece("1");
            pn1.setPiece("2");
            pn2.setPiece("3");
            pn3.setPiece("4");
            pn4.setPiece("5");
            pieceRepository.save(pn);
            pieceRepository.save(pn1);
            pieceRepository.save(pn2);
            pieceRepository.save(pn3);
            pieceRepository.save(pn4);
            pieceRepository.findAll().forEach(System.out::println);


            Category c1 = new Category();
            c1.setCatename("การจัดซื้อ");
            Category c2 = new Category();
            c2.setCatename("งบประมาณ");
            Category c3 = new Category();
            c3.setCatename("โครงการ");
            categoryRepository.save(c1);
            categoryRepository.save(c2);
            categoryRepository.save(c3);
            categoryRepository.findAll().forEach(System.out::println);

            Person pes1 = new Person();
            pes1.setPname("สมชาย สบายดี");
            Person pes2 = new Person();
            pes2.setPname("สมศรี ไม่มีเงิน");
            Person pes3 = new Person();
            pes3.setPname("สมพร นอนทั้งวัน");
            personRepository.save(pes1);
            personRepository.save(pes2);
            personRepository.save(pes3);
            personRepository.findAll().forEach(System.out::println);

            Statusmeet s1 = new Statusmeet();
            s1.setStatus("วาระที่ 1");
            Statusmeet s2 = new Statusmeet();
            s2.setStatus("วาระที่ 2");
            Statusmeet s3 = new Statusmeet();
            s3.setStatus("วาระที่ 3");
            statusmeetRepository.save(s1);
            statusmeetRepository.save(s2);
            statusmeetRepository.save(s3);
            statusmeetRepository.findAll().forEach(System.out::println);
        };

    }
}



