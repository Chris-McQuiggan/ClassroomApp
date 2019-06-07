package com.bae.buisness.service;

public interface ClassService {

	// C
	String addClass(String trainer);

	// R
	String getAllClasses();

	String getAClass(int id);

	// U
	String updateClass(String trainer, int id);

	// D
	String deleteClass(int id);

}
