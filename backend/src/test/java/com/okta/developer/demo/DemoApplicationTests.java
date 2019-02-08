package com.okta.developer.demo;

import com.okta.developer.demo.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoApplicationTests {


	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;


	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	//--------------------------------------Test Case Sprint#1 ????????????????????? B5902644----------------------------------
	@Test
	public void testAllMatchGrade() {
		Grade gr = new Grade();
		gr.setPoint(85);

		try {
			entityManager.persist(gr);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------->>Test All Match Grade<<------------------------");
		System.out.println();
		System.out.println();
		System.out.println();


	}

	@Test
	public void testGradecanNotnull() {
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
			System.out.println("---------------------->>Test Grade can Not Null!!<<------------------------");
			System.out.println();
			System.out.println();
			System.out.println();

			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
		}


	}

	@Test
	public void testGradeOverSize() {
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
			System.out.println("---------------------->>Test Grade Over Size<<------------------------");
			System.out.println();
			System.out.println();
			System.out.println();

			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}


	}

	@Test
	public void testGradeNotPattern() {
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
			System.out.println("---------------------->>Test Grade Not Pattern<<------------------------");
			System.out.println();
			System.out.println();
			System.out.println();

			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 2);
		}


	}
	//--------------------------------------Test Case Sprint#2 ?????????????????????????? B5902644 ----------------------------------

	@Test
	public void testSchoolCheckAllMatch() {
		SchoolCheck sck = new SchoolCheck();
		sck.setParrents("Jirasakk");
		try {
			entityManager.persist(sck);
			entityManager.flush();

			//fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------->>Test School Chec kAll Match<<------------------------");
		System.out.println();
		System.out.println();
		System.out.println();

	}
	@Test
	public void testSchoolCheckNull() {
		SchoolCheck sck = new SchoolCheck();
		sck.setParrents(null);
		try {
			entityManager.persist(sck);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------->>Test School Check Null<<------------------------");
			System.out.println();
			System.out.println();
			System.out.println();

			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}

	}
	@Test
	public void testSchoolCheckOversize(){
		SchoolCheck sck = new SchoolCheck();
		sck.setParrents("Pattaraphonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		try {
			entityManager.persist(sck);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------->>Test School Check Over Size<<------------------------");
			System.out.println();
			System.out.println();
			System.out.println();

			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testSchoolCheckMinsize(){

		SchoolCheck sck = new SchoolCheck();
		sck.setParrents("Pa");
		try {
			entityManager.persist(sck);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------->>Test School Check Min Size<<------------------------");
			System.out.println();
			System.out.println();
			System.out.println();

			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
	@Test
	public void testSchoolCheckNotPatternMatch(){

		SchoolCheck sck = new SchoolCheck();
		sck.setParrents("????????????");
		try {
			entityManager.persist(sck);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("---------------------->>Test School Check Not Pattern Match<<------------------------");
			System.out.println();
			System.out.println();
			System.out.println();

			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test(expected = javax.persistence.PersistenceException.class)
	public void testNameSchoolCheckBeUnique(){
		SchoolCheck sck = new SchoolCheck();
		sck.setParrents("Jirasak");
		entityManager.persist(sck);
		entityManager.flush();

		SchoolCheck sck1 = new SchoolCheck();
		sck1.setParrents("Jirasak");
		entityManager.persist(sck1);


		System.out.println();
		System.out.println("------------------------->> Name School Check BeUnique <<-------------------------");
		System.out.println();
		System.out.println();

		entityManager.flush();
		fail("Should not pass to this line");

	}




}
