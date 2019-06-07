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
	private String jSONClass1 = "{\"classID\":1,\"trainer\":\"Matt Hunt\"}";
	private String jSONClass2 = "{\"classID\":2,\"trainer\":\"Chester Gardner\"}";

	@Before
	public void setup() {
		cmr = new ClassMapRepository();
	}

	@Test
	public void getClassTestNoMatch() {
		cmr.getClassMap().put(1, class1);
		assertEquals("null", cmr.getAClass(2));
	}

	@Test
	public void getClassTestMatch() {
		cmr.getClassMap().put(1, class1);
		assertEquals(jSONClass1, cmr.getAClass(1));
	}

	@Test
	public void addClassTest1() {
		assertEquals(cmr.addClass(jSONClass1), "Classroom successfuly created");
		assertEquals(cmr.getClassMap().size(), 1);
	}

	@Test
	public void removeClassTest() {
		cmr.getClassMap().put(1, class1);
		cmr.deleteClass(1);
		assertEquals(false, cmr.getClassMap().containsKey(1));

	}

	@Test
	public void remove2ClassTest() {
		cmr.getClassMap().put(1, class1);
		cmr.getClassMap().put(2, class2);
		cmr.deleteClass(1);
		assertEquals(false, cmr.getClassMap().containsKey((Integer) 1));
		cmr.deleteClass(2);
		assertEquals(false, cmr.getClassMap().containsKey((Integer) 2));
	}

	@Test
	public void jsonStringToClasroomConversionTest() {
		String stringToTest = jSONClass1;
		Classroom testAccount = util.getObjectForJSON(stringToTest, Classroom.class);
		assertEquals(class1.getClassID(), testAccount.getClassID());
	}

	@Test
	public void classroomConversionToJSONTest() {
		String jsonAccount = jSONClass1;
		String stringToTest = util.getJSONForObject(class1);
		assertEquals(jsonAccount, stringToTest);

	}
}
