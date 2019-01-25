package com.okta.developer.demo.controller;

import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomController {
    @Autowired
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/Rooms")

    public Collection<Room> Room() {
        return roomRepository.findAll().stream().collect(Collectors.toList());
    }

}
