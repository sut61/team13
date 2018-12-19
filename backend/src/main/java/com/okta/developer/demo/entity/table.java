package com.okta.developer.demo;

import lombok.*;
import javax.persistence.*;
@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name = "Studytimetable")
public class Studytimetable {
 @Id
 @SequenceGenerator(name="No_STT",sequenceName="No_STT")
 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="No_STT")
 @Column(name = "No")
 private @NonNull Long idStudytimetable;
 private @NonNull String timedate;
 private @NonNull String day;
 @ManyToOne private Major majors;
 @ManyToOne private Room rooms;
 @ManyToOne private Personnel teachers;
public Studytimetable(String timedate, String day, Major major, Room room,
Personnel personnel){
 this.timedate = timedate;
 this.day = day;
 this.majors = major;
 this.rooms = room;
 this.teachers = personnel;}
}