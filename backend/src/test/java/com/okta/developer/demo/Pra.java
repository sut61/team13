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
public class Pra {


    @Autowired
    private PracticeRepository practiceRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testPracticeAllMatch() {
        Practice pr = new Practice();
        pr.setName("Waraphorn");
        pr.setNum("asdfghjk");
        try {
            entityManager.persist(pr);
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
    public void testPracticeNameNull() {
        Practice pr = new Practice();
        pr.setName(null);
        pr.setNum("asdfghhjk");
        try {
            entityManager.persist(pr);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test <<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testPracticeNumNull() {
        Practice pr = new Practice();
        pr.setName("Waraphorn");
        pr.setNum(null);
        try {
            entityManager.persist(pr);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Practice num Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPracticeNameOverSize() {
        Practice pr = new Practice();
        pr.setName("Parateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        pr.setNum("asdfghjk");
        try {
            entityManager.persist(pr);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Practice Name Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPracticeNameMinSize() {
        Practice pr = new Practice();
        pr.setName("Wara");
        pr.setNum("asdfghjk");
        try {
            entityManager.persist(pr);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Practice Name Min Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPracticeNumOverSize() {
        Practice pr = new Practice();
        pr.setName("Waraphorn");
        pr.setNum("asdfghjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        try {
            entityManager.persist(pr);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Practice Name Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPracticeNumMinSize() {
        Practice pr = new Practice();
        pr.setName("Waraphorn");
        pr.setNum("asd");
        try {
            entityManager.persist(pr);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Practice Num Min Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void testNamePracticeBeUnique() {
        Practice pr = new Practice();
        pr.setName("Thanyakorn");
        pr.setNum("asdfghjk");
        entityManager.persist(pr);
        entityManager.flush();

        Practice pr1 = new Practice();
        pr1.setName("Thanyakorn");
        pr1.setNum("asdfghjk");
        entityManager.persist(pr1);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->> Test Practice BeUnique <<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

        entityManager.flush();
        fail("Should not pass to this line");

    }


    //======================-------------------------------------- Test Case Buildingon class entity ----------------------------------======================
    @Test
    public void testBuildingParentsSuccessful() {
        Building ge = new Building();
        ge.setBuilding("genders");

        try {
            entityManager.persist(ge);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Check Building Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testBuildingParentsNull() {
        Building ge = new Building();
        ge.setBuilding(null);


        try {
            entityManager.persist(ge);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Building Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //======================-------------------------------------- Test Case Roomm  class entity ----------------------------------======================
    @Test
    public void testRoommParentsSuccessful() {
        Roomm  ge = new Roomm();
        ge.setRoomm ("Roomm");

        try {
            entityManager.persist(ge);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Check Roomm Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testRoommParentsNull() {
        Roomm ge = new Roomm();
        ge.setRoomm(null);


        try {
            entityManager.persist(ge);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Roomm Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //======================-------------------------------------- Test Case Cla  class entity ----------------------------------======================
    @Test
    public void testClaParentsSuccessful() {
        Cla  ge = new Cla();
        ge.setCla ("Cla");

        try {
            entityManager.persist(ge);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Check Cla Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testClaParentsNull() {
        Cla ge = new Cla();
        ge.setCla(null);


        try {
            entityManager.persist(ge);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Cla Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}