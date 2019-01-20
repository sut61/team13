package com.okta.developer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.okta.developer.demo.entity.PatientName;

@RepositoryRestResource
    public
    interface PatientNameRepository extends JpaRepository<PatientName, Long> {

}