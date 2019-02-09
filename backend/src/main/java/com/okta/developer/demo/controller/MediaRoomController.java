package com.okta.developer.demo.controller;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MediaRoomController{
    @Autowired private ApplicantRepository applicantRepository;
    @Autowired private ActivityRepository activityRepository;
    @Autowired private PrefixRepository prefixRepository;

    @GetMapping("/Applicant")
    public Collection<Applicant> applicant(){
        return applicantRepository.findAll();
    }

    
    @PostMapping("/Applicant/addApplicant")
    public Applicant newApplicant(Applicant newApplicant,@PathVariable Date date,@RequestBody() Map<String,Object> body) {
        Optional<Prefix> prefix = prefixRepository.findById(Long.valueOf(body.get("prefix").toString()));
        Optional<Activity> activity = activityRepository.findById(Long.valueOf(body.get("activity").toString()));
                
        newApplicant.setActivity(activity.get());
        newApplicant.setPrefix(prefix.get());
        newApplicant.setApplicantName(body.get("applicantName").toString());
        newApplicant.setTime(body.get("time").toString());
        newApplicant.setDate(body.get("date").toString());
        return applicantRepository.save(newApplicant);
    }

    //=============Activity====================
    @GetMapping("/Activity")
    public Collection<Activity> activity(){
        return activityRepository.findAll();
    }
    
    @PostMapping("/Activity/addActivity/{activity}")
    public Activity newActivity(@PathVariable String activity){
        Activity newActivity = new Activity(activity); 
        return activityRepository.save(newActivity); 
    }

}
