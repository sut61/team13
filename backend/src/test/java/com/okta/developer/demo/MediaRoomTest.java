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
    @Autowired private PrefixRepository prefixRepository;
    @Autowired private LevelRepository levelRepository;
    @Autowired private EquipmentRepository equipmentRepository;

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
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล3");
        equipment.setEquipment("ชุดยานยนต์จำลอง");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
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

    //===============================test null============================================
    @Test
    public void testApplicantNameNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName(null);
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล3");
        equipment.setEquipment("ชุดยานยนต์จำลอง");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
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
    public void testPrefixNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        prefix.setPrefix(null);
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล3");
        equipment.setEquipment("ชุดยานยนต์จำลอง");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Prefix Null<<------------------------");
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
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        prefix.setPrefix("นาย");
        activity.setActivity(null);
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล3");
        equipment.setEquipment("ชุดยานยนต์จำลอง");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
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
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom(null);
        level.setLevel("อนุบาล3");
        equipment.setEquipment("ชุดยานยนต์จำลอง");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Media Room Null<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testLevelNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel(null);
        equipment.setEquipment("ชุดยานยนต์จำลอง");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Level Null<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
    @Test
    public void testEquipmentNull() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("ชาญชัย นนทะชัย");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล3");
        equipment.setEquipment(null);

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Media Room Null<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();

    }
//==========================================================================================================


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
        mediaRoom1.setMediaRoom("Media1");

        entityManager.persist(mediaRoom1);
        entityManager.flush();

        MediaRoom mediaRoom2 = new MediaRoom();
        mediaRoom2.setMediaRoom("Media1");

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

    //===================test Size============================
    @Test
    public void testApplicantNameSize() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("Parateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        activity.setActivity("ทำกิจกรรมกลุ่ม");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล1");
        equipment.setEquipment("โทรทัศน์");
        prefix.setPrefix("นางสาว");
        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Applicant Name Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testActivitySize() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("Parat manee");
        activity.setActivity("ทำกิจกรรมกลุ่มมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมมม");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล1");
        equipment.setEquipment("โทรทัศน์");
        prefix.setPrefix("นางสาว");

        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Activity Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testPrefixSize() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("Parate fjfpdf");
        activity.setActivity("ทำกิจกรรมกลุ่ม");
        mediaRoom.setMediaRoom("media1");
        level.setLevel("อนุบาล1");
        equipment.setEquipment("โทรทัศน์");
        prefix.setPrefix("นางสาวววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววววว");
        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            entityManager.persist(prefix);
            entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Prefix Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testLevelSize() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("Parate fjfpdf");
        activity.setActivity("ทำกิจกรรมกลุ่ม");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล11111111111111111122222222222333333333333333333333333344444444444");
        equipment.setEquipment("โทรทัศน์");
        prefix.setPrefix("นางสาว");
        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            //entityManager.persist(prefix);
            //entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Level Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testEquipmentSize() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("Parate fjfpdf");
        activity.setActivity("ทำกิจกรรมกลุ่ม");
        mediaRoom.setMediaRoom("Media4");
        level.setLevel("อนุบาล1");
        equipment.setEquipment("ชุด");
        prefix.setPrefix("นางสาว");
        try {
            entityManager.persist(applicant);
            entityManager.flush();
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
            entityManager.persist(activity);
            entityManager.flush();
            //entityManager.persist(prefix);
            //entityManager.flush();
            entityManager.persist(level);
            entityManager.flush();
            entityManager.persist(equipment);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Equipment Size<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //==========================test Pattern==============================
    @Test
    public void TestMediaRoomPatern(){
        MediaRoom mediaRoom = new MediaRoom();
        mediaRoom.setMediaRoom("mejdjgkl455");

        try{
            entityManager.persist(mediaRoom);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Media Room Pattern<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}
