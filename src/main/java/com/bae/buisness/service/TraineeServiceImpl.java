package com.bae.buisness.service;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {
	@Inject
	private TraineeRepository repo;

	@Override
	public String addTrainee(String trainee) {
		return repo.addTrainee(trainee);
	}

	@Override
	public String getAllTrainees() {

		return null;
	}

	@Override
	public String getATrainee(int id) {
		return repo.getATrainee(id);
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
