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
		return repo.getAllTrainees();
	}

	@Override
	public String getATrainee(int id) {
		return repo.getATrainee(id);
	}

	@Override
	public String updateTrainee(String trainee, int id) {
		return repo.updateTrainee(trainee, id);
	}

	@Override
	public String deleteTrainee(int id) {
		return repo.deleteTrainee(id);
	}

}
