package com.bae.buisness.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ClassRepository;

public class ClassServiceImpl implements ClassService {
	@Inject
	private ClassRepository repo;

	@Override
	public String addClass(String classroom) {
		return repo.addClass(classroom);
	}

	@Override
	public String getAllClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAClass(int id) {
		return repo.getAClass(id);
	}

	@Override
	public String updateClass(String classroom, int id) {
		return repo.updateClass(classroom, id);
	}

	@Override
	public String deleteClass(int id) {
		return repo.deleteClass(id);
	}

}
