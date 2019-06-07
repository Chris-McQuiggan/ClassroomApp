package com.bae.buisness.service;

public interface ClassService {

	// C
	String addClass(String classroom);

	// R
	String getAllClasses();

	String getAClass(int id);

	// U
	String updateClass(String classroom, int id);

	// D
	String deleteClass(int id);

}
