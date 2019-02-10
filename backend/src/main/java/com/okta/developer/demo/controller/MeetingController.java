package com.okta.developer.demo.controller;
import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MeetingController {
    @Autowired private  MeetingRepository meetingRepository;
    @Autowired private  CategoryRepository categoryRepository;
    @Autowired private  StatusmeetRepository statusmeetRepository;
    @Autowired private PersonRepository personRepository;
    @GetMapping(path="/Meeting")
    public Collection<Meeting> Meeting() {
        return meetingRepository.findAll();}

    @GetMapping(path="/Category")
    public List<Category> Category() {
        return categoryRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping(path="/Statusmeet")
    public List<Statusmeet> Statusmeet() {
        return statusmeetRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping(path="/Person")
    public List<Person> Person() {
        return personRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/meeting/{cate_id}/{stat_id}/{per_id}/{topic}/{descrip}/{day}")
    public  Meeting meeting(@PathVariable Long cate_id,@PathVariable Long stat_id,@PathVariable Date day,
            @PathVariable Long per_id,@PathVariable String topic,@PathVariable String descrip) {
        Category cy = categoryRepository.findById(cate_id).get();
        Statusmeet stm = statusmeetRepository.findById(stat_id).get();
        Person per = personRepository.findById(per_id).get();


        Meeting meeting = new Meeting();
        meeting.setTopic(topic);
        meeting.setDescrip(descrip);
        meeting.setCategory(cy);
        meeting.setStatusmeet(stm);
        meeting.setPerson(per);
        meeting.setDay(day);

        meetingRepository.save(meeting);
        return  meeting;
    }
}