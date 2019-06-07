package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.buisness.service.ClassService;

@Path("/Classroom")
public class ClassController {
	@Inject
	private ClassService service;

	@Path("/getAClass/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAClass(@PathParam("id") int id) {
		return service.getAClass(id);
	}

	@Path("/addClass")
	@POST
	@Produces({ "application/json" })
	public String addClass(String classroom) {
		return service.addClass(classroom);
	}

}
