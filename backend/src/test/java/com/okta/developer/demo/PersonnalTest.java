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



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest

public class PersonnalTest {
    @Autowired
    private PersonnalRepository personnalRepository;


    @Autowired
    private TestEntityManager entityManager;

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
        System.out.println("---------------------->>Test Case Sprint#1 Chutimon Wongsa B5908851<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        //validator = factory.getValidator();
    }

    @Test
    public void testPersonnalAllMatch() {
        Personnal per = new Personnal();
        per.setFname("Chutimon");
        per.setLname("Wongsa");
        per.setJob_id("B5908851");
        per.setIdentificationNumber("1199900642331");
        per.setPhonenumber("0990589313");
        try {
            entityManager.persist(per);
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
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
    public void testPersonnalFnameNull() {
        Personnal per = new Personnal();
        per.setFname(null);
        per.setLname("Wongsa");
        per.setJob_id("B5908851");
        per.setIdentificationNumber("1199900642331");
        per.setPhonenumber("0990589313");
        try {
            entityManager.persist(per);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Personnal Fname Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testPersonnalLnameNull() {
        Personnal per = new Personnal();
        per.setFname("Chutimon");
        per.setLname(null);
        per.setJob_id("B5908851");
        per.setIdentificationNumber("1199900642331");
        per.setPhonenumber("0990589313");
        try {
            entityManager.persist(per);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Personnal Lname Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testPersonnalJobidNull() {
        Personnal per = new Personnal();
        per.setFname("Chutimon");
        per.setLname("Wongsa");
        per.setJob_id(null);
        per.setIdentificationNumber("1199900642331");
        per.setPhonenumber("0990589313");
        try {
            entityManager.persist(per);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Personnal Jod_id Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testPersonnalIdentificationNumberNull() {
        Personnal per = new Personnal();
        per.setFname("Chutimon");
        per.setLname("Wongsa");
        per.setJob_id("B5908851");
        per.setIdentificationNumber(null);
        per.setPhonenumber("0990589313");
        try {
            entityManager.persist(per);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Personnal IdentificationNumber Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testPersonnalPhonenumberNull() {
        Personnal per = new Personnal();
        per.setFname("Chutimon");
        per.setLname("Wongsa");
        per.setJob_id("B5908851");
        per.setIdentificationNumber("1199900642331");
        per.setPhonenumber(null);
        try {
            entityManager.persist(per);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Personnal Phonenumber Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    // ---------------------------OverSize----------------------------------------------
    @Test
    public void testPersonnalFNameOverSize() {
        Personnal per = new Personnal();
        per.setFname("Chutimonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        per.setLname("Wongsa");
        per.setJob_id("B5908851");
        per.setIdentificationNumber("1199900642331");
        per.setPhonenumber("0990589313");
        try {
            entityManager.persist(per);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Personnal Fname Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    //-------------------------Pattern---------------------------
    @Test
    public void testPersonnalFnameCanNotPattern() {
        Personnal per = new Personnal();
        per.setFname("!@#$%^&*(()(*&^%$#@");
        per.setLname("Wongsa");
        try {
            entityManager.persist(per);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Personnal Fname Connot Pattern<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    //----------------------ข้อมูลห้ามซ้ำ-------------------------
    @Test
    public void testPersonnalBeUnique() {
        Personnal s1 = new Personnal();
        s1.setFname("Chutimon");
        Personnal s2 = new Personnal();
        s2.setFname("Chutimon");
        try {
            entityManager.persist(s2);
            entityManager.flush();
            fail("Should not pass to this line");

        }catch (javax.validation.ConstraintViolationException e){
            System.out.println("--------------------------------->> test Personnal BeUnique <<-------------------------- ");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }catch (javax.persistence.PersistenceException e){
            System.out.println("--------------------------------->> test Personnal BeUnique <<-------------------------- ");
            System.out.println("--------------------------------->> UNIQUE COLUMN <<-------------------------- ");
            e.printStackTrace();
        }
    }

}
