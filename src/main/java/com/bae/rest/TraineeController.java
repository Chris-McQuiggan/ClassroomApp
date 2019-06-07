package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

	@Path("/addTrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String trainee) {
		return service.addTrainee(trainee);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") int id) {
		return service.deleteTrainee(id);
	}

	@Path("/updateTrainee/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(String trainee, @PathParam("id") int id) {
		return service.updateTrainee(trainee, id);
	}
}
