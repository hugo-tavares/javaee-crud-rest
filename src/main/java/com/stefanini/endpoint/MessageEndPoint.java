package com.stefanini.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageEndPoint {
	
	@GET
	public Response index() {
		String result = "Página home";
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example: " + msg;

		return Response.status(200).entity(result).build();
 
	}

}