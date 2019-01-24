package com.demo.Controller;

import com.demo.entity.*;
import com.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentControllerAll {

    @Autowired private StudentReporitory studentRepository;
    @Autowired private GenderReporitory genderRepository;
    @Autowired private NationalityReporitory nationalityRepository;
    @Autowired private ReligionRepository religionRepository;

    @GetMapping(path="/Student")
    public Collection<Student> Student() {
        return studentRepository.findAll();}

    @GetMapping(path="/Gender")
    public List<Gender> Gender() {
        return genderRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping(path="/Nationality")
    public List<Nationality> Nationality() {
        return nationalityRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping(path="/Religion")
    public List<Religion> Religion() {
        return religionRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/student/{ge_id}/{nationality_id}/{religion_id}/{username}/{num}/{nation}/{disease}/{allergy}")
    public Student student(@PathVariable long ge_id,@PathVariable long nationality_id,@PathVariable long religion_id
            ,@PathVariable String username,@PathVariable String disease,@PathVariable String allergy,@PathVariable String num,@PathVariable String nation){

        Gender gender = genderRepository.findById(ge_id).get();
        Nationality nationality = nationalityRepository.findById(nationality_id).get();
        Religion religion = religionRepository.findById(religion_id).get();

        Student student = new Student();
        student.setUsername(username);
        student.setNum(num);
        student.setGender(gender);
        student.setNationality(nationality);
        student.setReligion(religion);
        student.setNation(nation);
        student.setDisease(disease);
        student.setAllergy(allergy);
        studentRepository.save(student);
        return student;
    }
}

