package com.bae.persistence.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

public class TraineeDBRepository implements TraineeRepository {

	@Inject
	JSONUtil util;
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String addTrainee(String trainee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getATrainee(int id) {
		return util.getJSONForObject(em.find(Trainee.class, id));
	}

	@Override
	public String updateTrainee(String trianee, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTrainee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
