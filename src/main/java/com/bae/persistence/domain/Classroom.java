package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int classID;
	private String trainer;

	public Classroom() {

	}

	public Classroom(int classID, String trainer) {
		super();
		this.classID = classID;
		this.trainer = trainer;
	}

	public int getClassID() {
		return classID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
}
