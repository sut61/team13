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

public class BorrowsportequipmentTest {
    @Autowired
    private StudentsRepository studenstRepository;
    @Autowired private BorrowSportsEquipmentRepository borrowSportsEquipmentRepository;

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
        System.out.println("---------------------->>Test Case Sprint#2 Chutimon Wongsa B5908851<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        // validator = factory.getValidator();

    }

    @Test
    public void testBorrowsportequipmentAllMatch() {
        BorrowSportsEquipment b = new BorrowSportsEquipment();
        b.setName_borrow("Chutimon Wongsa");
        b.setName_lender("Nongluk Wongsa");
        try {
            entityManager.persist(b);


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
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
    public void testBorrowsportequipmentNameBorrowNull() {
        BorrowSportsEquipment b = new BorrowSportsEquipment();
        b.setName_borrow(null);
        b.setName_lender("Nongluk Wongsa");
        try {
            entityManager.persist(b);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Borrow Sports Equipment Name_Borrow Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }

    @Test
    public void testBorrowsportequipmentNameLenderNull() {
        BorrowSportsEquipment b = new BorrowSportsEquipment();
        b.setName_borrow("Chutimon Wongsa");
        b.setName_lender(null);
        try {
            entityManager.persist(b);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Borrow Sports Equipment Name_Lender Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }

    @Test
    public void testBorrowsportequipmentMinsize(){

        BorrowSportsEquipment sck = new BorrowSportsEquipment();
        sck.setName_borrow("Chutimon Wongsa");
        try {
            entityManager.persist(sck);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Borrow Sports Equipment Parent Min Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testBorrowsportequimentOversize(){
        BorrowSportsEquipment b = new BorrowSportsEquipment();
        b.setName_borrow("Chutimon Wongsaaaaaaaaaa");
        b.setName_lender("Nongluk Wongsa");
        try {
            entityManager.persist(b);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Borrow Sports Equipment Parent Over Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }



    //------------------------------ Class---------------------------

    @Test
    public void testSportsEquipmentParentsSuccessful() {
        SportsEquipment se = new SportsEquipment();
        se.setSportsE("ฟุตบอล");

        try {
            entityManager.persist(se);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Check SportsEquipment Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testSportsEquipmentParentsNull() {
        SportsEquipment se = new SportsEquipment();
        se.setSportsE(null);

        try {
            entityManager.persist(se);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check SportsEquipment Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }
    @Test
    public void testPieceParentsSuccessful() {
        Piece p = new Piece();
        p.setPiece("1");

        try {
            entityManager.persist(p);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Check Piece Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testPieceParentsNull() {
        Piece p = new Piece();
        p.setPiece(null);

        try {
            entityManager.persist(p);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Piece Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    @Test
    public void testClassroomsParentsSuccessful() {
        Classrooms c = new Classrooms();
        c.setClassroom("อนุบาล 1");

        try {
            entityManager.persist(c);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Check Classrooms Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testClassroomsParentsNull() {
        Classrooms c = new Classrooms();
        c.setClassroom(null);

        try {
            entityManager.persist(c);
            entityManager.flush();
            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Check Classrooms Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    //----------------------ข้อมูลห้ามซ้ำ-------------------------

    @Test
    public void testBorrowsportequipmentBeUnique() {
        BorrowSportsEquipment borr = new BorrowSportsEquipment();
        borr.setName_borrow("Chutimon Wongsa");
        entityManager.persist(borr);


        BorrowSportsEquipment borr1 = new BorrowSportsEquipment();
        borr1.setName_borrow("Chutimon wongsa");

        try {
            entityManager.persist(borr1);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("--------------------------------->> test Borrowsportequipment BeUnique <<-------------------------- ");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("--------------------------------->> test Borrowsportequipment BeUnique <<-------------------------- ");
            System.out.println("--------------------------------->> UNIQUE COLUMN <<-------------------------- ");
            e.printStackTrace();
        }
    }
}
