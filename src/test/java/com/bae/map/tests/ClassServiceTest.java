package com.bae.map.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Classroom;
import com.bae.persistence.repository.ClassMapRepository;
import com.bae.util.JSONUtil;

public class ClassServiceTest {

	private ClassMapRepository cmr;
	private JSONUtil util = new JSONUtil();
	private Classroom class1 = new Classroom(1, "Matt Hunt");
	private Classroom class2 = new Classroom(2, "Chester Gardner");
	private Classroom class3 = new Classroom(3, "Louis Simth");

	@Before
	public void setup() {
		cmr = new ClassMapRepository();
	}

	@Test
	public void getClassTestNoMatch() {
		cmr.getClassMap().put(1, class1);
		System.out.println(cmr.getAClass(2));
		assertEquals("null", cmr.getAClass(2));
	}

	@Test
	public void getClassTestMatch() {
		cmr.getClassMap().put(1, class1);
		assertEquals("{\"classID\":1,\"trainer\":\"Matt Hunt\"}", cmr.getAClass(1));
	}

	@Test
	public void jsonStringToClasroomConversionTest() {
		String stringToTest = "{\"classID\":1,\"trainer\":\"Matt Hunt\"}";
		Classroom testAccount = util.getObjectForJSON(stringToTest, Classroom.class);
		assertEquals(class1.getClassID(), testAccount.getClassID());
	}

	@Test
	public void classroomConversionToJSONTest() {
		String jsonAccount = "{\"classID\":1,\"trainer\":\"Matt Hunt\"}";
		String stringToTest = util.getJSONForObject(class1);
		assertEquals(jsonAccount, stringToTest);

	}
}
