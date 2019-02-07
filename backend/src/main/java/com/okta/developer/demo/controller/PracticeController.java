package com.okta.developer.demo.controller;

        import com.okta.developer.demo.entity.*;
        import com.okta.developer.demo.repository.*;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.Collection;
        import java.util.Date;
        import java.util.List;
        import java.util.stream.Collectors;
        @RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PracticeController {

            @Autowired private PracticeRepository practiceRepository;
    @Autowired private RoommRepository roommRepository;
    @Autowired private BuildingRepository buildingRepository;
    @Autowired private ClaRepository claRepository;

    @GetMapping(path="/Practice")
    public Collection<Practice> Practice() {
        return practiceRepository.findAll();}

    @GetMapping(path="/Roomm")
    public List<Roomm> Roomm() {
        return roommRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping(path="/Building")
    public List<Building> Building() {
        return buildingRepository.findAll().stream()
                .collect(Collectors.toList());
    }
            @GetMapping(path="/Cla")
            public List<Cla> Cla() {
                return claRepository.findAll().stream()
                        .collect(Collectors.toList());
            }


           