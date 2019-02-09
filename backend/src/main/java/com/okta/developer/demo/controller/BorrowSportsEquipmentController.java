package com.okta.developer.demo.controller;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class BorrowSportsEquipmentController {
    @Autowired private BorrowSportsEquipmentRepository borrowsportsequipmentRepository;
    @Autowired private SportsEquipmentRepository sportsequipmentRepository;
    @Autowired private ClassroomsRepository classroomsRepository;
    @Autowired private PieceRepository pieceRepository;
    @GetMapping(path = "/BorrowSportsEquipment")
    public Collection<BorrowSportsEquipment> borrowsportsequipment() {
        return borrowsportsequipmentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/SportEquipment")
    public Collection<SportsEquipment> sportsequipment() {
        return sportsequipmentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Classroooms")
    public Collection<Classrooms> classrooms() {
        return classroomsRepository.findAll().stream().collect(Collectors.toList());

    }
    @GetMapping(path = "/Piece")
    public Collection<Piece> pieces() {
        return pieceRepository.findAll().stream().collect(Collectors.toList());

    }
    @PostMapping(path = "/borrowsportsequipment/{name_borrow}/{classroom}/{sportequipment_id}/{piece}/{day_borrow}/{day_return}/{name_lender}")
    public BorrowSportsEquipment borrowsportsequipment(@PathVariable String name_borrow,@PathVariable Long classroom,
                                                       @PathVariable Long sportequipment_id,@PathVariable Long piece,@PathVariable Date day_borrow,
                                                       @PathVariable Date day_return,@PathVariable String name_lender) {
        Classrooms cr = classroomsRepository.findById(classroom).get();
        SportsEquipment se = sportsequipmentRepository.findById(sportequipment_id).get();
        Piece p = pieceRepository.findById(piece).get();


        BorrowSportsEquipment bse = new BorrowSportsEquipment();
        bse.setName_borrow(name_borrow);
        bse.setDay_borrow(day_borrow);
        bse.setDay_return(day_return);
        bse.setName_lender(name_lender);
        bse.setClassrooms(cr);
        bse.setPiece(p);
        bse.setSportsequipment(se);
        borrowsportsequipmentRepository.save(bse);
        return bse;

    }


}

