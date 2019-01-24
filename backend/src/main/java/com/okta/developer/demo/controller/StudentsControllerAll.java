package com.okta.developer.demo.controller;


import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentsControllerAll {

    @Autowired private StudentsRepository studenstRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private NationalityRepository nationalityRepository;
    @Autowired private ReligionRepository religionRepository;

    @GetMapping(path="/Student")
    public Collection<Students> Student() {
        return studenstRepository.findAll();}

    @GetMapping(path="/Gender")
    public List<Genders> Gender() {
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
    @PostMapping("/students/{ge_id}/{nationality_id}/{religion_id}/{username}/{num}")
    public Students students(@PathVariable long ge_id,@PathVariable long nationality_id,@PathVariable long religion_id
            ,@PathVariable String username,@PathVariable String num){

        Genders gender = genderRepository.findById(ge_id).get();
        Nationality nationality = nationalityRepository.findById(nationality_id).get();
        Religion religion = religionRepository.findById(religion_id).get();

        Students student = new Students();
        student.setName(username);
        student.setNum(num);
        student.setGender(gender);
        student.setNationality(nationality);
        student.setReligion(religion);
       studenstRepository.save(student);
        return student;
    }
}

