package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int studentID;
	private String traineeName;

	public Trainee() {

	}

	public Trainee(int studentID, String traineeName) {
		super();
		this.studentID = studentID;
		this.traineeName = traineeName;
	}

	public int getClassID() {
		return studentID;
	}

	public String getTrainee() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
}
