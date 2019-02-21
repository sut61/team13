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

public class HospitalRoom {
    @Autowired private PatientNameRepository patientNameRepository;
    @Autowired private TreatmentRepository treatmentRepository;
    @Autowired private SymptomRepository symptomRepository;
    @Autowired private HospitalRepository hospitalRepository;
    @Autowired private PrefixRepository prefixRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testPatientNameAllMatch() {

        PatientName patientName = new PatientName();
        patientName.setPatientName("ชาญชัย นนทะชัย");
        patientName.setSuggestion("ควรพักผ่อนให้เพียงพอ");

        try {
            entityManager.persist(patientName);
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
    @Test
    public void testTreatmentMatch() {

        Treatment treatment = new Treatment();
        treatment.setTreatment("ปวดหัว");

        try {
            entityManager.persist(treatment);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Treatment Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    @Test
    public void testSymptomMatch() {

        Symptom symptom = new Symptom();
        symptom.setSymptom("ทำแผล");

        try {
            entityManager.persist(symptom);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Symptom Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    @Test
    public void testHospitalMatch() {

        Hospital hospital = new Hospital();
        hospital.setHospital("โรงพยาบาล มทส");

        try {
            entityManager.persist(hospital);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("---------------------->>Test Hospital Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    @Test
    public void testPrefixMatch() {

        Prefix prefix = new Prefix();
        prefix.setPrefix("เด็กชาย");

        try {
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
        System.out.println("---------------------->>Test Prefix Match<<------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    //===============================test null============================================
    @Test
    public void testPatientNameNull() {
        PatientName patientName = new PatientName();
        patientName.setPatientName(null);
        patientName.setSuggestion("พักผ่อนให้เพียงพอ");
        try {
            entityManager.persist(patientName);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Patient Name Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSuggestionNull() {
        PatientName patientName = new PatientName();
        patientName.setPatientName("ชาญชัย นนทะชัย");
        patientName.setSuggestion(null);
        try {
            entityManager.persist(patientName);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Suggestion Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSymptomNull() {
        Symptom symptom = new Symptom();
        symptom.setSymptom(null);

        try {
            entityManager.persist(symptom);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Symptom Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTreatmentNull() {
        Treatment treatment = new Treatment();
        treatment.setTreatment(null);

        try {
            entityManager.persist(treatment);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Treatment Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testHospitalNull() {
        Hospital hospital = new Hospital();
        hospital.setHospital(null);

        try {
            entityManager.persist(hospital);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Hospital Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testPrefixNull() {
        Prefix prefix = new Prefix();
        prefix.setPrefix(null);

        try {
            entityManager.persist(prefix);
            entityManager.flush();


        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("---------------------->>Test Prefix Null<<------------------------");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    //================================test Unique=============================================
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testHospitalUnique() {
        Hospital hospital = new Hospital();
        hospital.setHospital("โรงพยาบาล มทส");
        entityManager.persist(hospital);
        entityManager.flush();

        Hospital hospital2 = new Hospital();
        hospital2.setHospital("โรงพยาบาล มทส");
        entityManager.persist(hospital2);
        entityManager.flush();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->>Test Hospital BeUnique<<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        fail("Should not pass to this line");

    }
    @Test(expected = javax.persistence.PersistenceException.class)
    public void testSymptomUnique() {
        Symptom symptom1 = new Symptom();
        symptom1.setSymptom("ปวดท้อง");
        entityManager.persist(symptom1);
        entityManager.flush();

        Symptom symptom2 = new Symptom();
        symptom2.setSymptom("ปวดท้อง");
        entityManager.persist(symptom2);
        entityManager.flush();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------->>Test Symptom BeUnique<<-------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
        fail("Should not pass to this line");

    }
}
