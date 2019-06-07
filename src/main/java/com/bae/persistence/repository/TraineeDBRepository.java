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
		Trainee trainee1 = util.getObjectForJSON(trainee, Trainee.class);
		em.persist(trainee1);

		return "Success:---  " + trainee;
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
	public String updateTrainee(String trainee, int id) {
		Trainee trainee1 = util.getObjectForJSON(trainee, Trainee.class);
		Trainee traineeToUpdate = em.getReference(Trainee.class, id);
		if (traineeToUpdate != null) {
			traineeToUpdate.setTraineeName(trainee1.getTrainee());
			traineeToUpdate.setClassID(trainee1.getClassID());
			em.persist(traineeToUpdate);
		}
		return "Updated:---   " + trainee;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteTrainee(int id) {
		Trainee trainee1 = em.getReference(Trainee.class, id);
		em.remove(trainee1);
		return "Trainee Deleted";
	}

}
