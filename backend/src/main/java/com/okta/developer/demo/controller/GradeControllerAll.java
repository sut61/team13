package com.okta.developer.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;
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
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GradeControllerAll{

    @Autowired private GradeReporitory gradeReporitory;
    @Autowired private GpaRepository gpaRepository;
    @Autowired private MajorReporitory majorReporitory;
    @Autowired private ProfessorReporitory professorReporitory;
   @Autowired private StudentReporitory studentReporitory;


    @GetMapping("/Grades")
    private Grade getGradeId(@PathVariable Long id){
        return this.gradeReporitory.findById(id).get();
    }



    @GetMapping("/gpaa")
    public Collection<Gpa> gpas() {
        return gpaRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/Majors")
    public Collection<Major> Major() {
        return majorReporitory.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/Professors")
    public Collection<Professor> Professor() {
        return professorReporitory.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping(path = "/Students")
    public Collection<Student> Student() {
        return studentReporitory.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping(path = "/grade/{point}/{gpa}/{major}/{pro}/{stu}")
    public Grade grade(@PathVariable int point ,@PathVariable Long gpa , @PathVariable Long major , @PathVariable Long pro,
                       @PathVariable Long stu){
        Gpa g1 = gpaRepository.findById(gpa).get();
        Major ma1 = majorReporitory.findById(major).get();
        Professor pro1 = professorReporitory.findById(pro).get();
        Student stu1 = studentReporitory.findById(stu).get();
        Grade grade = new Grade(point,ma1,pro1,stu1,g1);
        gradeReporitory.save(grade);
        return grade;
    }

}
