package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.buisness.service.TraineeService;

@Path("/Trainee")
public class TraineeController {

	@Inject
	private TraineeService service;

	@Path("/getATrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String getATrainee(@PathParam("id") int id) {
		return service.getATrainee(id);
	}
}
