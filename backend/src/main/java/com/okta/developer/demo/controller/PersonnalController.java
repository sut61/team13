package com.okta.developer.demo.controller;

import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.PersistenceDelegate;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PersonnalController {
    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private PersonnalRepository personnalRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private ReligionRepository religionRepository;

    @GetMapping(path = "/degree")
    public Collection<Degree> degrees() {
        return degreeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/education")
    public Collection<Education> educations() {
        return educationRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/gender")
    public Collection<Genders> genders() {
        return genderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/personal")
    public Collection<Personnal> personnals() {
        return personnalRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/position")
    public Collection<Position> positions() {
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/religion")
    public Collection<Religion> religions() {
        return religionRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/personnal/{re_id}/{edu_id}/{gen_id}/{po_id}/{de_id}/{birth}/{fname}/{lname}/{jobid}/{nat}/{extraction}/{iden}/{major}/{phone}/{email}")
    public Personnal personnal(@PathVariable Long re_id, @PathVariable Long edu_id, @PathVariable Long gen_id,
                               @PathVariable Long po_id, @PathVariable Long de_id, @PathVariable Date birth, @PathVariable String fname,
                               @PathVariable String lname, @PathVariable String jobid, @PathVariable String nat, @PathVariable String extraction, @PathVariable String iden,
                               @PathVariable String major, @PathVariable String phone, @PathVariable String email) {

        Degree degree = degreeRepository.findById(de_id).get();
        Education education = educationRepository.findById(edu_id).get();
        Genders gender = genderRepository.findById(gen_id).get();
        Position position = positionRepository.findById(po_id).get();
        Religion religion = religionRepository.findById(re_id).get();

        Personnal personnal = new Personnal();
        personnal.setBirthday(birth);
        personnal.setE_mail(email);
        personnal.setFname(fname);
        personnal.setIdentificationNumber(iden);
        personnal.setLname(lname);
        personnal.setExtraction(extraction);
        personnal.setJob_id(jobid);
        personnal.setEducational(major);
        personnal.setNationality(nat);
        personnal.setPhonenumber(phone);
        personnal.setGender(gender);
        personnal.setPosition(position);
        personnal.setReligion(religion);
        personnal.setDegree(degree);
        personnal.setEducation(education);
        personnalRepository.save(personnal);
        return personnal;
    }
}