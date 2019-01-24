package com.okta.developer.demo.repository;

import com.okta.developer.demo.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonnalRepository extends JpaRepository<Personnal, Long>{
        Personnal findByFname(String fname);
    }

