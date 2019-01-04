package com.stefanini.endpoint;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.exception.CampoInvalidoException;
import com.stefanini.exception.PessoaInexistenteException;
import com.stefanini.model.Candidato;
import com.stefanini.service.CandidatoService;

@Path("/candidatos")
public class CandidatoEndPoint {
	@Inject
	CandidatoService candidatoService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidato> index() {
		return candidatoService.showAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Candidato find(@PathParam("id") int id) throws PessoaInexistenteException {
		return candidatoService.find(id);
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Candidato candidato) throws CampoInvalidoException {
		Candidato candidatoCadastrado = candidatoService.insert(candidato);
		return Response.status(201).entity(candidatoCadastrado).build();
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Candidato candidato) throws PessoaInexistenteException {
		candidatoService.update(candidato);
		return Response.status(200).entity(candidato).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) throws PessoaInexistenteException {
		candidatoService.delete(id);
		return Response.status(200).build();
	}
	
	
}
