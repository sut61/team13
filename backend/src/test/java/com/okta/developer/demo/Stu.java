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
public class Stu {


    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testStudentsAllMatch() {
        Students st = new Students();
        st.setName("Jirasakk");
        st.setNum("1199900628249");
        try {
            entityManager.persist(st);
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
    public void testStudentsStudentsNull() {
        Students st = new Students();
        st.setName(null);
        st.setNum("1199900628249");
        try {
            entityManager.persist(st);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Student Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testStudentsNumNull() {
        Students st = new Students();
        st.setName("Paratee");
        st.setNum(null);
        try {
            entityManager.persist(st);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Student num Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testStudentsNameOverSize() {
        Students st = new Students();
        st.setName("Parateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        st.setNum("1199900628249");
        try {
            entityManager.persist(st);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Student Name Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testStudentsNameMinSize() {
        Students st = new Students();
        st.setName("Paee");
        st.setNum("1199900628249");
        try {
            entityManager.persist(st);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Student Name Min Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testStudentsNameCanNotPattern() {
        Students st = new Students();
        st.setName("%)@&%)@($*@@)%$#$*");
        st.setNum("1199900628249");
        try {
            entityManager.persist(st);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Student Name Connot Pattern<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void testNameStudentBeUnique() {
        Students st = new Students();
        st.setName("Thanyakorn");
        st.setNum("1199900628249");
        entityManager.persist(st);
        entityManager.flush();

        Students st1 = new Students();
        st1.setName("Thanyakorn");
        st1.setNum("1199900628249");
        entityManager.persist(st1);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->> Test Student BeUnique <<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

        entityManager.flush();
        fail("Should not pass to this line");

    }

    //======================-------------------------------------- Test Case Genders class entity ----------------------------------======================
    @Test
    public void testGendersParentsSuccessful() {
        Genders ge = new Genders();
        ge.setGenders("genders");

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
        System.out.println("---------------------->>Test Check Genders Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testGendersParentsNull() {
        Genders ge = new Genders();
        ge.setGenders(null);


        try {
            entityManager.persist(ge);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Genders Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //======================-------------------------------------- Test Case Nationality class entity ----------------------------------======================
    @Test
    public void testNationalityParentsSuccessful() {
        Nationality ge = new Nationality();
        ge.setNation("Nationality");

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
        System.out.println("---------------------->>Test Check Nationality Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testNationalityParentsNull() {
        Nationality ge = new Nationality();
        ge.setNation(null);


        try {
            entityManager.persist(ge);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Nationality Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    //======================-------------------------------------- Test Case Religion class entity ----------------------------------======================
    @Test
    public void testReligionParentsSuccessful() {
        Religion ge = new Religion();
        ge.setReligion("genders");

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
        System.out.println("---------------------->>Test Check Religion Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testReligionParentsNull() {
        Religion ge = new Religion();
        ge.setReligion(null);


        try {
            entityManager.persist(ge);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Religion Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}