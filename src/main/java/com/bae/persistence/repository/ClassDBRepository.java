package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Default
public class ClassDBRepository implements ClassRepository {
	@Inject
	JSONUtil util;
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String addClass(String trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAClass(int id) {
		return util.getJSONForObject(em.find(Classroom.class, id));
	}

	@Override
	public String updateClass(String trainer, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClass(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
