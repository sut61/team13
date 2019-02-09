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
public class GradeTest {


    @Autowired
    private ClassroomsRepository classroomsRepository;
    @Autowired
    private ParentsRepository parentsRepository;
    @Autowired
    private SchoolCheckRepository schoolCheckRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private StudentReporitory studentReporitory;
    @Autowired
    private GradeReporitory gradeReporitory;
    @Autowired
    private GpaRepository gpaRepository;
    @Autowired
    private MajorReporitory majorReporitory;
    @Autowired
    private ProfessorReporitory professorReporitory;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //=====================================================================================================================================================================

    //======================--------------------------------------Test Case Sprint#1 Mr.Jirasak Kankrasang B5902644----------------------------------======================

    //=====================================================================================================================================================================
    @Test
    public void testMatchGradePointSuccessful() {
        Grade gr = new Grade();
        gr.setPoint(85);

        try {
            entityManager.persist(gr);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Match Grade Point Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();


    }

    @Test
    public void testGradeOverPoint() {
        Grade gr1 = new Grade();
        gr1.setPoint(500);

        try {
            entityManager.persist(gr1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Grade Over Point<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }

    @Test
    public void testGradeNegative() {
        Grade gr1 = new Grade();
        gr1.setPoint(-50);

        try {
            entityManager.persist(gr1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Grade Negative<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }


    }

    @Test
    public void testGradePointZero() {
        Grade gr1 = new Grade();
        gr1.setPoint(0);

        try {
            entityManager.persist(gr1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Grade Point Zero<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }


    }

    //======================-------------------------------------- Test Case Student class entity ----------------------------------======================
    @Test
    public void testGradeStudentNameSuccessful() {
        Student stu = new Student();
        stu.setStudent_name("Thanyaphon");

        try {
            entityManager.persist(stu);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {


            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Grade Student Name Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testGradeStudentNameNull() {
        Student stu = new Student();
        stu.setStudent_name(null);

        try {
            entityManager.persist(stu);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Grade Student Name Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void testGradeStudentNameBeUnique() {
        Student st = new Student();
        st.setStudent_name("Phiyada");
        entityManager.persist(st);
        entityManager.flush();

        Student st1 = new Student();
        st1.setStudent_name("Phiyada");
        ;
        entityManager.persist(st1);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->>Test Grade Student Name BeUnique<<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();


        entityManager.flush();

        fail("Should not pass to this line");

    }

    //======================-------------------------------------- Test Case Major class entity ----------------------------------======================
    @Test
    public void testGradeMajorNameSuccessful() {
        Major mj = new Major();
        mj.setMajorname("Mathematics");

        try {
            entityManager.persist(mj);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {


            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Grade Major Name Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testGradeMajorNameNull() {

        Major mj = new Major();
        mj.setMajorname(null);

        try {
            entityManager.persist(mj);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Grade Major Name Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

    }

    //======================-------------------------------------- Test Case Professor class entity ----------------------------------======================
    @Test
    public void testGradeProfessorNameSuccessful() {
        Professor pro = new Professor();
        pro.setProfessor_name("Angsumalin");

        try {
            entityManager.persist(pro);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {


            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Grade Professor Name Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testGradeProfessorNameNull() {
        Professor pro = new Professor();
        pro.setProfessor_name(null);

        try {
            entityManager.persist(pro);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Grade Professor Name Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }

    //======================-------------------------------------- Test Case Professor class entity ----------------------------------======================
    @Test
    public void testGradeGpaNameSuccessful() {
        Gpa gpa = new Gpa();
        gpa.setGgpa("4.00");

        try {
            entityManager.persist(gpa);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {


            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Grade gpa  Successful<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testGradeGpaNull() {
        Gpa gpa = new Gpa();
        gpa.setGgpa(null);

        try {
            entityManager.persist(gpa);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Grade gpa Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }


    }


//=====================================================================================================================================================================
//=====================================================================================================================================================================
//======================------------------------------------ End of Test Case Sprint#1   Mr.Jirasak Kankrasang B5902644 ----------------------------------=============
//=====================================================================================================================================================================
//=====================================================================================================================================================================
}
