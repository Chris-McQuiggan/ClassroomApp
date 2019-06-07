package com.bae.map.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Trainee;
import com.bae.persistence.repository.TraineeMapRepository;
import com.bae.util.JSONUtil;

public class TraineeServiceTest {

	private TraineeMapRepository tmr;
	private JSONUtil util = new JSONUtil();
	private Trainee trainee1 = new Trainee(1, "Joe Bloggs", 1);
	private Trainee trainee2 = new Trainee(2, "Jane Bloggs", 1);
	private Trainee trainee3 = new Trainee(3, "David Bloggs", 2);

	@Before
	public void setup() {
		tmr = new TraineeMapRepository();
	}

	@Test
	public void getTraineeTestNoMatch() {
		tmr.getTraineeMap().put(1, trainee1);
		System.out.println(tmr.getATrainee(2));
		assertEquals("null", tmr.getATrainee(2));
	}

	@Test
	public void getTraineeTestMatch() {
		tmr.getTraineeMap().put(1, trainee1);
		assertEquals("{\"studentID\":1,\"traineeName\":\"Joe Bloggs\",\"classID\":1}", tmr.getATrainee(1));
	}

	@Test
	public void jsonStringToTraineeConversionTest() {
		String stringToTest = "{\"studentID\":1,\"traineeName\":\"Joe Bloggs\",\"classID\":1}";
		Trainee testAccount = util.getObjectForJSON(stringToTest, Trainee.class);
		assertEquals(trainee1.getClassID(), testAccount.getClassID());
	}

	@Test
	public void classroomConversionToJSONTest() {
		String jsonAccount = "{\"studentID\":1,\"traineeName\":\"Joe Bloggs\",\"classID\":1}";
		String stringToTest = util.getJSONForObject(trainee1);
		assertEquals(jsonAccount, stringToTest);
	}

}
