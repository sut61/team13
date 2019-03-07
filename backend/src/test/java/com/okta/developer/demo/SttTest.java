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
public class SttTest{
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSttAllMatch(){
        Studytimetable s = new Studytimetable();
        s.setTimedate("Arrrsed");
        s.setDay("erswsfr");
        try {
            entityManager.persist(s);
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
    public void testSttTimedateNull() {
        Studytimetable s = new Studytimetable();
        s.setTimedate(null);
        s.setDay("asdfghhjk");
        try {
            entityManager.persist(s);
            entityManager.flush();


        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Timedate Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSttDayNull() {
        Studytimetable s = new Studytimetable();
        s.setTimedate("Arrrsed");
        s.setDay(null);
        try {
            entityManager.persist(s);
            entityManager.flush();


        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Day Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSttTimedateOverSize() {
        Studytimetable s = new Studytimetable();
        s.setTimedate("Arrrsedddddddddddddddddddddddddddddddddffffddddddd");
        s.setDay("asdfghhjk");
        try {
            entityManager.persist(s);
            entityManager.flush();


        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Day Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSttTimedateMinSize() {
        Studytimetable s = new Studytimetable();
        s.setTimedate("gd");
        s.setDay("asdfghhjk");
        try {
            entityManager.persist(s);
            entityManager.flush();


        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Day Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSttDayOverSize() {
        Studytimetable s = new Studytimetable();
        s.setTimedate("Arrrsred");
        s.setDay("asdfghhjkdafefewafedfefesdfewfaescesfefsassssssssss");
        try {
            entityManager.persist(s);
            entityManager.flush();


        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Day Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSttDayMinSize() {
        Studytimetable s = new Studytimetable();
        s.setTimedate("Arrrsed");
        s.setDay("yy");
        try {
            entityManager.persist(s);
            entityManager.flush();


        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Day Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSttTimedateBeUnique() {
        Studytimetable s = new Studytimetable();
        s.setTimedate("kitoto");
        entityManager.persist(s);


        Studytimetable s1 = new Studytimetable();
        s1.setTimedate("kitoto");

        try {
            entityManager.persist(s1);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("--------------------------------->> test Meeting BeUnique <<-------------------------- ");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("--------------------------------->> test Meeting BeUnique <<-------------------------- ");
            System.out.println("--------------------------------->> UNIQUE COLUMN <<-------------------------- ");
            e.printStackTrace();
        }
    }

    // @Test
    // public void TestSttCheckNotPaternMatch(){
    //     Studytimetable s = new Studytimetable();
    //     s.setDay("_#####??&&%$");
    //     entityManager.persist(s);

    //     try{
    //         entityManager.persist(s);
    //         entityManager.flush();
    //     } catch(javax.validation.ConstraintViolationException e){
    //         System.out.println();
    //         System.out.println();
    //         System.out.println();
    //         System.out.println("------------>>Test  Pattern<<-----------");
    //         System.out.println(e.getMessage());
    //         System.out.println();
    //         System.out.println();
    //         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    //         assertEquals(violations.isEmpty(), false);
    //         assertEquals(violations.size(), 2);
    //     }
    // }

    @Test
    public void testMajorNull() {
        Major mj = new Major();
        mj.setMajorname(null);
        try {
            entityManager.persist(mj);
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
    public void testRoomNull() {
        Room r = new Room();
        r.setRoomname(null);
        try {
            entityManager.persist(r);
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
    public void testPersonnelNull() {
        Personnel ps = new Personnel();
        ps.setTeachers(null);
        try {
            entityManager.persist(ps);
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


}
