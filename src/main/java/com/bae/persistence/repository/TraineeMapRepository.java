package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {

	private Map<Integer, Trainee> traineeMap = new HashMap<>();

	private JSONUtil util = new JSONUtil();

	public Map<Integer, Trainee> getTraineeMap() {
		return traineeMap;
	}

	public void setClassMap(Map<Integer, Trainee> traineeMap) {
		this.traineeMap = traineeMap;
	}

	@Override
	public String addTrainee(String trainee) {
		Trainee newAccount = util.getObjectForJSON(trainee, Trainee.class);
		traineeMap.put(newAccount.getClassID(), newAccount);
		return "Trainee successfuly created";
	}

	@Override
	public String getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getATrainee(int id) {
		return util.getJSONForObject(traineeMap.get(id));
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
