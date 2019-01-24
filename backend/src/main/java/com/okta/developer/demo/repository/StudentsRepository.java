package com.okta.developer.demo.repository;

import com.okta.developer.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Long> {
}
