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
	private int classID;

	public Trainee() {

	}

	public Trainee(int studentID, String traineeName, int classID) {
		super();
		this.studentID = studentID;
		this.traineeName = traineeName;
		this.classID = classID;
	}

	public int getStudentID() {
		return studentID;
	}

	public String getTrainee() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}
}
