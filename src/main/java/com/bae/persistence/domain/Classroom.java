package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int classID;
	private String trainer;

	@ManyToOne(targetEntity = Trainee.class)
	@JoinColumn
	private List<Trainee> traineelist;

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

	public List<Trainee> getTraineelist() {
		return traineelist;
	}

	public void setTraineelist(List<Trainee> traineeListIn) {
		this.traineelist = traineeListIn;
	}
}
