package com.okta.developer.demo.repository;

import com.okta.developer.demo.entity.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality,Long> {
}
