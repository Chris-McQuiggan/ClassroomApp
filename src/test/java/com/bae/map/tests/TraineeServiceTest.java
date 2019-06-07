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
	private String jSONTrainee1 = "{\"studentID\":1,\"traineeName\":\"Joe Bloggs\",\"classID\":1}";
	private String jSONTrainee2 = "{\"studentID\":2,\"traineeName\":\"Jane Bloggs\",\"classID\":1}";
	private String jSONTrainee3 = "{\"studentID\":3,\"traineeName\":\"David Bloggs\",\"classID\":2}";

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
		assertEquals(jSONTrainee1, tmr.getATrainee(1));
	}

	@Test
	public void addTraineeTest1() {
		assertEquals(tmr.addTrainee(jSONTrainee1), "Trainee successfuly created");
		assertEquals(tmr.getTraineeMap().size(), 1);
	}

	@Test
	public void removeTraineeTest() {
		tmr.getTraineeMap().put(1, trainee1);
		tmr.deleteTrainee(1);
		assertEquals(false, tmr.getTraineeMap().containsKey(1));

	}

	@Test
	public void remove2TraineesTest() {
		tmr.getTraineeMap().put(1, trainee1);
		tmr.getTraineeMap().put(2, trainee2);
		tmr.deleteTrainee(1);
		assertEquals(false, tmr.getTraineeMap().containsKey((Integer) 1));
		tmr.deleteTrainee(2);
		assertEquals(false, tmr.getTraineeMap().containsKey((Integer) 2));
	}

	@Test
	public void updateTraineeTest() {
		tmr.getTraineeMap().put(1, trainee1);
		tmr.updateTrainee(jSONTrainee2, 1);
		assertEquals("Jane Bloggs", tmr.getTraineeMap().get(1).getTrainee());
	}

	@Test
	public void jsonStringToTraineeConversionTest() {
		String stringToTest = jSONTrainee1;
		Trainee testAccount = util.getObjectForJSON(stringToTest, Trainee.class);
		assertEquals(trainee1.getClassID(), testAccount.getClassID());
	}

	@Test
	public void classroomConversionToJSONTest() {
		String jsonAccount = jSONTrainee1;
		String stringToTest = util.getJSONForObject(trainee1);
		assertEquals(jsonAccount, stringToTest);
	}

}
