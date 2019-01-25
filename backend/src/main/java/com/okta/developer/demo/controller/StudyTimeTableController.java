package com.okta.developer.demo.controller;

import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
 @CrossOrigin(origins = "http://localhost:4200")
 @RestController

 public class StudyTimeTableController {
  @Autowired private final StudyTimeTableRepository Sttrepository;
  @Autowired private RoomRepository roomRepository;
  @Autowired private PersonnelRepository personnelRepository;
  @Autowired private MajorReporitory majorRepository;

    public StudyTimeTableController(StudyTimeTableRepository STTrepository){
            this.Sttrepository = STTrepository; }
  @GetMapping("/Studytimetables")
  public Collection<Studytimetable> Studytimetable() {
  return Sttrepository.findAll(); }
  @PostMapping("/stt/add/{day},{time},{teacher},{room},{subject}")
  public Studytimetable newStudytimetable(@PathVariable String
  day, @PathVariable String time,@PathVariable String teacher,@PathVariable String
  room,@PathVariable String subject){

     Studytimetable stt = new Studytimetable();
 Personnel teacheradd = personnelRepository.findByFname(teacher);
 Room roomadd = roomRepository.findByRoomname(room);
 Major majorr = majorRepository.findByMajorname(subject);
 stt.setDay("monday");
 stt.setTimedate(time);
 stt.setTeachers(teacheradd);
 stt.setRooms(roomadd);
 stt.setMajor(majorr);

  return Sttrepository.save(stt);
 }
 @RequestMapping(value ="/delete/{idStudytimetable}")
 public void deleteStudyTimeTable(Studytimetable stt,@PathVariable Long idStudytimetable){
  Sttrepository.deleteById(idStudytimetable);
 }
}