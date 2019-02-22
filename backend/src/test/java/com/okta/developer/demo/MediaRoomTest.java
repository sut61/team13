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
        //applicant.setTime("14.00-16.00");
        //applicant.setDate("02/12/2019");
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
/*    @Test
    public void testMediaRoomAllMatch() {

        MediaRoom mediaRoom = new MediaRoom();
        mediaRoom.setMediaRoom("Media4");

        try {
            //entityManager.persist(mediaRoom);
            //entityManager.flush();
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
    public void testPrefixMatch() {

        Prefix prefix = new Prefix();
        prefix.setPrefix("นาย");

        try {
            //entityManager.persist(prefix);
            //entityManager.flush();
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

    }*/

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
        //applicant.setTime("14.00-16.00");
        //applicant.setDate("12/02/2562");
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
        //applicant.setTime("14.00-16.00");
        //applicant.setDate("12/02/2562");
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
        //applicant.setTime("14.00-16.00");
        //applicant.setDate("12/02/2562");
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
        //applicant.setTime("14.00-16.00");
        //applicant.setDate("12/02/2562");
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
        //applicant.setTime("14.00-16.00");
        //applicant.setDate("12/02/2562");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("media4");
        level.setLevel(null);
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
        //applicant.setTime("14.00-16.00");
        //applicant.setDate("12/02/2562");
        prefix.setPrefix("นาย");
        activity.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom.setMediaRoom("media3");
        level.setLevel("อนุบาล3");
        equipment.setEquipment(null);

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
//==========================================================================================================


    //=====================================test Unique=====================================================
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testPrefixUnique() {
        Applicant applicant1 = new Applicant();
        MediaRoom mediaRoom1 = new MediaRoom();
        Prefix prefix1 = new Prefix();
        Activity activity1 = new Activity();
        Level level1 = new Level();
        Equipment equipment1 = new Equipment();

        applicant1.setApplicantName("ชาญชัย");
        activity1.setActivity("ทำกิจกรรมกลุ่ม");
        mediaRoom1.setMediaRoom("media1");
        level1.setLevel("อนุบาล1");
        equipment1.setEquipment("โทรทัศน์");
        prefix1.setPrefix("นางสาว");

        entityManager.persist(applicant1);
        entityManager.flush();
        entityManager.persist(mediaRoom1);
        entityManager.flush();
        entityManager.persist(activity1);
        entityManager.flush();
        entityManager.persist(prefix1);
        entityManager.flush();
        entityManager.persist(level1);
        entityManager.flush();
        entityManager.persist(equipment1);
        entityManager.flush();

        Applicant applicant2 = new Applicant();
        MediaRoom mediaRoom2 = new MediaRoom();
        Activity activity2 = new Activity();
        Level level2 = new Level();
        Equipment equipment2 = new Equipment();
        Prefix prefix2 = new Prefix();

        applicant2.setApplicantName("ชาญชัย นนทะชัย");
        activity2.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom2.setMediaRoom("media4");
        level2.setLevel("อนุบาล3");
        equipment2.setEquipment("ชุดยานยนต์จำลอง");
        prefix2.setPrefix("นางสาว");

        entityManager.persist(applicant2);
        entityManager.flush();
        entityManager.persist(mediaRoom2);
        entityManager.flush();
        entityManager.persist(activity2);
        entityManager.flush();
        entityManager.persist(level2);
        entityManager.flush();
        entityManager.persist(equipment2);
        entityManager.flush();
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
        Applicant applicant1 = new Applicant();
        MediaRoom mediaRoom1 = new MediaRoom();
        Prefix prefix1 = new Prefix();
        Activity activity1 = new Activity();
        Level level1 = new Level();
        Equipment equipment1 = new Equipment();

        applicant1.setApplicantName("ชาญชัย");
        activity1.setActivity("ทำกิจกรรมกลุ่ม");
        mediaRoom1.setMediaRoom("media1");
        level1.setLevel("อนุบาล1");
        equipment1.setEquipment("โทรทัศน์");
        prefix1.setPrefix("นางสาว");

        entityManager.persist(applicant1);
        entityManager.flush();
        entityManager.persist(mediaRoom1);
        entityManager.flush();
        entityManager.persist(activity1);
        entityManager.flush();
        entityManager.persist(prefix1);
        entityManager.flush();
        entityManager.persist(level1);
        entityManager.flush();
        entityManager.persist(equipment1);
        entityManager.flush();

        Applicant applicant2 = new Applicant();
        MediaRoom mediaRoom2 = new MediaRoom();
        Activity activity2 = new Activity();
        Level level2 = new Level();
        Equipment equipment2 = new Equipment();
        Prefix prefix2 = new Prefix();

        applicant2.setApplicantName("ชาญชัย นนทะชัย");
        activity2.setActivity("ทำกิจกรรมกลุ่มในรายวิชาศิลปะ");
        mediaRoom2.setMediaRoom("media1");
        level2.setLevel("อนุบาล3");
        equipment2.setEquipment("ชุดยานยนต์จำลอง");
        prefix2.setPrefix("เด็กชาย");

        entityManager.persist(applicant2);
        entityManager.flush();
        entityManager.persist(mediaRoom2);
        entityManager.flush();
        entityManager.persist(activity2);
        entityManager.flush();
        entityManager.persist(level2);
        entityManager.flush();
        entityManager.persist(equipment2);
        entityManager.flush();
        entityManager.persist(prefix2);
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
        mediaRoom.setMediaRoom("media1");
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
        mediaRoom.setMediaRoom("media1");
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
    public void testMediaRoomSize() {
        Applicant applicant = new Applicant();
        MediaRoom mediaRoom = new MediaRoom();
        Prefix prefix = new Prefix();
        Activity activity = new Activity();
        Level level = new Level();
        Equipment equipment = new Equipment();

        applicant.setApplicantName("Parate fjfpdf");
        activity.setActivity("ทำกิจกรรมกลุ่ม");
        mediaRoom.setMediaRoom("media1111111111111111111111111111111111111111111111111111111111111111111111111111111");
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
            System.out.println("---------------------->>Test Media Room Size<<------------------------");
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
        mediaRoom.setMediaRoom("media1");
        level.setLevel("อนุบาล11111111111111111122222222222333333333333333333333333344444444444");
        equipment.setEquipment("โทรทัศน์");
        prefix.setPrefix("นางสาว");
        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
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
        mediaRoom.setMediaRoom("media1");
        level.setLevel("อนุบาล1");
        equipment.setEquipment("ชุด");
        prefix.setPrefix("นางสาว");
        try {
            entityManager.persist(applicant);
            entityManager.flush();
            entityManager.persist(mediaRoom);
            entityManager.flush();
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
    /*@Test
    public void testMediaRoomPattern(){

        MediaRoom mediaRoom = new MediaRoom();
        mediaRoom.setMediaRoom("&_#####??&&%$");
        try {
            entityManager.persist(mediaRoom);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test School Check Not Pattern Match<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }*/
}
