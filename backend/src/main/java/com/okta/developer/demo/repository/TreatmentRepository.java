package com.okta.developer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.okta.developer.demo.entity.Treatment;

@RepositoryRestResource
    public
    interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}