package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@Inject
	JSONUtil util;
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Transactional(TxType.REQUIRED)
	@Override
	public String addTrainee(String trainee) {

		return "Trainee successfuly created";
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

	@Transactional(TxType.REQUIRED)
	@Override
	public String updateTrainee(String trianee, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteTrainee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
