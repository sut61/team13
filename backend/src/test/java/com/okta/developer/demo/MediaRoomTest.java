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
public class MediaRoomTest {
    @Autowired private ApplicantRepository applicantRepository;
    @Autowired private ActivityRepository activityRepository;
    @Autowired private MediaRoomRepository mediaRoomRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //==========================test all match=====================================
    @Test
    public void testApplicantAllMatch() {
        Applicant applicant = new Applicant();
        //MediaRoom mediaRoom = new MediaRoom();
        //Prefix prefix = new Prefix();
        //Activity activity = new Activity();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        applicant.setTime("14.00-16.00");
        applicant.setDate("02/12/2019");
        //prefix.setPrefix("นาย");
        //activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        //mediaRoom.setMediaRoom("Media4");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            //entityManager.persist(activity);
            //entityManager.flush();
            //entityManager.persist(prefix);
            //entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Applicant all Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testMediaRoomAllMatch() {

        MediaRoom mediaRoom = new MediaRoom();
        mediaRoom.setMediaRoom("Media4");

        try {
            entityManager.persist(mediaRoom);
            entityManager.flush();
        }
        catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Media Room Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testActivityAllMatch() {

        Activity activity = new Activity();
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");


        try {
            entityManager.persist(activity);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Activity Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    //===============================test null============================================
    @Test
    public void testApplicantNameNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();

        applicant.setApplicantName(null);
        applicant.setTime("14.00-16.00");
        applicant.setDate("12/02/2562");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test applicantName NUll<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @Test
    public void testTimeNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        applicant.setTime(null);
        applicant.setDate("12/02/2562");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test prefix NUll<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testDateNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        applicant.setTime("14.00-16.00");
        applicant.setDate(null);
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Applicant all Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testPrefixNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        applicant.setTime("14.00-16.00");
        applicant.setDate("12/02/2562");
        prefix.setPrefix(null);
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Applicant all Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    @Test
    public void testActivityNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        applicant.setTime("14.00-16.00");
        applicant.setDate("12/02/2562");
        prefix.setPrefix("นาย");
        activity.setActivity(null);
        mediaRoom.setMediaRoom("Media4");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Applicant all Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testMediaRoomNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        applicant.setTime("14.00-16.00");
        applicant.setDate("12/02/2562");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom(null);

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Applicant all Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    //=====================================test Unique=====================================================
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testPrefixUnique() {
        Prefix prefix1 = new Prefix();
        prefix1.setPrefix("นางสาว");
        entityManager.persist(prefix1);
        entityManager.flush();

        Prefix prefix2 = new Prefix();
        prefix2.setPrefix("นางสาว");
        entityManager.persist(prefix2);
        entityManager.flush();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->>Test Prefix BeUnique<<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        fail("Should not pass to this line");

    }

    @Test(expected = javax.persistence.PersistenceException.class)
    public void testMediaRoomUnique() {
        MediaRoom mediaRoom1 = new MediaRoom();
        mediaRoom1.setMediaRoom("ห้องสื่อการเรียนรู้1");
        entityManager.persist(mediaRoom1);
        entityManager.flush();

        MediaRoom mediaRoom2 = new MediaRoom();
        mediaRoom2.setMediaRoom("ห้องสื่อการเรียนรู้1");
        entityManager.persist(mediaRoom2);
        entityManager.flush();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->>Test Media Room BeUnique<<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        fail("Should not pass to this line");

    }
}
