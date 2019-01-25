package com.okta.developer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.okta.developer.demo.entity.*;

@RepositoryRestController
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface AuthorRepository extends JpaRepository <Author,Long>{

}