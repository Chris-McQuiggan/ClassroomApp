package com.bae.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

		return classroom;
	}

	@Override
	public String getAllClasses() {
		TypedQuery<Classroom> query = null;
		query = em.createQuery("SELECT c FROM Classroom c", Classroom.class);
		List<Classroom> classList = query.getResultList();
		return util.getJSONForObject(classList);
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
		return classroom;
	}

	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteClass(int id) {
		Classroom class1 = em.getReference(Classroom.class, id);
		em.remove(class1);
		return "Classroom Deleted";
	}

}
