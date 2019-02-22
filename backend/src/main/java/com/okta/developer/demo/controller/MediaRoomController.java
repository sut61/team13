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
    @Autowired private MediaRoomRepository mediaRoomRepository;
    @Autowired private LevelRepository levelRepository;
    @Autowired private EquipmentRepository equipmentRepository;


    @GetMapping("/Applicant")
    public Collection<Applicant> applicant(){
        return applicantRepository.findAll();
    }

    
    @PostMapping("/Applicant/addApplicant")
    public Applicant newApplicant(Applicant newApplicant,@RequestBody() Map<String,Object> body) {
        Optional<Prefix> prefix = prefixRepository.findById(Long.valueOf(body.get("prefix").toString()));
        Optional<Activity> activity = activityRepository.findById(Long.valueOf(body.get("activity").toString()));
        Optional<MediaRoom> mediaRoom = mediaRoomRepository.findById(Long.valueOf(body.get("mediaRoom").toString()));
        Optional<Level> level = levelRepository.findById(Long.valueOf(body.get("level").toString()));
        Optional<Equipment> equipment = equipmentRepository.findById(Long.valueOf(body.get("equipment").toString()));
                
        newApplicant.setLevel(level.get());
        newApplicant.setEquipment(equipment.get());
        newApplicant.setActivity(activity.get());
        newApplicant.setMediaRoom(mediaRoom.get());
        newApplicant.setPrefix(prefix.get());
        newApplicant.setApplicantName(body.get("applicantName").toString());

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

    //=============MediaRoom====================
    @GetMapping("/MediaRoom")
    public Collection<MediaRoom> mediaRoom(){
        return mediaRoomRepository.findAll();
    }

    @PostMapping("/MediaRoom/addMediaRoom/{mediaRoom}")
    public MediaRoom newMediaRoom(@PathVariable String mediaRoom){
        MediaRoom newMediaRoom = new MediaRoom(mediaRoom);
        return mediaRoomRepository.save(newMediaRoom);
    }

    //=============Level====================
    @GetMapping("/Level")
    public Collection<Level> level(){
        return levelRepository.findAll();
    }

    @PostMapping("/Level/addLevel/{level}")
    public Level newLevel(@PathVariable String level){
        Level newLevel = new Level(level);
        return levelRepository.save(newLevel);
    }
    //=============Equipment====================
    @GetMapping("/Equipment")
    public Collection<Equipment> equipment(){
        return equipmentRepository.findAll();
    }

    @PostMapping("/Equipment/addEquipment/{equipment}")
    public Equipment newEquipment(@PathVariable String equipment){
        Equipment newEquipment = new Equipment(equipment);
        return equipmentRepository.save(newEquipment);
    }

}
