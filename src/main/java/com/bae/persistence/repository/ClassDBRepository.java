package com.bae.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class ClassDBRepository implements ClassRepository {
	@Inject
	JSONUtil util;
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Transactional(TxType.REQUIRED)
	@Override
	public String addClass(String classroom) {
		Classroom class1 = util.getObjectForJSON(classroom, Classroom.class);
		em.persist(class1);

		return "Success:---  " + classroom;
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

	@Transactional(TxType.REQUIRED)
	@Override
	public String updateClass(String classroom, int id) {
		Classroom class1 = util.getObjectForJSON(classroom, Classroom.class);
		Classroom classToUpdate = em.getReference(Classroom.class, id);
		if (classToUpdate != null) {
			classToUpdate.setTrainer(class1.getTrainer());
			em.persist(classToUpdate);
		}
		return "Updated:---   " + classroom;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteClass(int id) {
		Classroom class1 = em.getReference(Classroom.class, id);
		em.remove(class1);
		return "Classroom Deleted";
	}

}
