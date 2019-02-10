package com.okta.developer.demo;
import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



@RunWith(SpringRunner.class)
@DataJpaTest
public class MeetingTest{
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MeetingRepository meetingRepository;
    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testCaseSprintFirstChutimon() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Case Sprint#2 Supachai Sroyklam B5925803<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testMeetingAllMatch(){
        Meeting mt = new Meeting();
        mt.setTopic("Arrrsed");
        mt.setDescrip("erswsfr");
        try {
            entityManager.persist(mt);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test  Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @Test
    public void testMeetingTopicNull() {
        Meeting mt = new Meeting();
        mt.setTopic(null);
        mt.setDescrip("asdfghhjk");
        try {
            entityManager.persist(mt);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Topic null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //
    @Test
    public void testMeetingDescripNull() {
        Meeting mt = new Meeting();
        mt.setTopic("asdfgerd");
        mt.setDescrip(null);
        try {
            entityManager.persist(mt);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Descrip Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //
    @Test
    public void testMeetingTopicOverSize() {
        Meeting mt = new Meeting();
        mt.setTopic("Paratggggggggggggggggggggggggggggggggggggggggee");
        mt.setDescrip("asdfghjk");
        try {
            entityManager.persist(mt);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Topic Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //
    @Test
    public void testMeetingTopicMinSize() {
        Meeting mt = new Meeting();
        mt.setTopic("bibi");
        mt.setDescrip("asdfghjk");
        try {
            entityManager.persist(mt);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Topic Min Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //
    @Test
    public void testMeetingDescripOverSize() {
        Meeting mt = new Meeting();
        mt.setTopic("nafefda");
        mt.setDescrip("asdiadsuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        try {
            entityManager.persist(mt);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Descrip Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testMeetingDescripMinSize() {
        Meeting mt = new Meeting();
        mt.setTopic("buuyufhfgs");
        mt.setDescrip("at");
        try {
            entityManager.persist(mt);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Descrip Min Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    }