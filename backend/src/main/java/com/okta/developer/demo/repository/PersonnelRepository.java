package com.okta.developer.demo.repository;

import com.okta.developer.demo.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    Personnel findByFname(String fname);
}
