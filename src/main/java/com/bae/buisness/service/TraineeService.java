package com.bae.buisness.service;

public interface TraineeService {
	// C
	String addTrainee(String trainee);

	// R
	String getAllTrainees();

	String getATrainee(int id);

	// U
	String updateTrainee(String trianee, int id);

	// D
	String deleteTrainee(int id);
}
