package com.bae.persistence.repository;

public interface TraineeRepository {
	// C
	String addTrainee(String trainee);

	// R
	String getAllTrainees();

	String getATrainee(int id);

	// U
	String updateTrainee(String trainee, int id);

	// D
	String deleteTrainee(int id);
}
