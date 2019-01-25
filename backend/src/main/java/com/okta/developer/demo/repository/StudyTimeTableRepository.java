package com.okta.developer.demo.repository;

import com.okta.developer.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface StudyTimeTableRepository extends JpaRepository<Studytimetable, Long> {
    Studytimetable findByidStudytimetable(Long idStudytimetable);
    @Override
    void deleteById(Long idStudytimetable);

}
