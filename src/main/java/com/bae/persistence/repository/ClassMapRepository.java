package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Alternative
public class ClassMapRepository implements ClassRepository {

	private Map<Integer, Classroom> classMap = new HashMap<>();

	private JSONUtil util = new JSONUtil();

	public Map<Integer, Classroom> getClassMap() {
		return classMap;
	}

	public void setClassMap(Map<Integer, Classroom> classMap) {
		this.classMap = classMap;
	}

	@Override
	public String addClass(String classroom) {
		Classroom newAccount = util.getObjectForJSON(classroom, Classroom.class);
		classMap.put(newAccount.getClassID(), newAccount);
		return "Classroom successfuly created";
	}

	@Override
	public String getAllClasses() {
		return util.getJSONForObject(classMap);
	}

	@Override
	public String getAClass(int id) {
		return util.getJSONForObject(classMap.get(id));
	}

	@Override
	public String updateClass(String classroom, int id) {
		Classroom classToUpdate = util.getObjectForJSON(classroom, Classroom.class);
		classMap.put(id, classToUpdate);
		return "Classroom successfully updated";
	}

	@Override
	public String deleteClass(int id) {
		classMap.remove((Integer) id);
		return "Classroom successfully removed";
	}

}
