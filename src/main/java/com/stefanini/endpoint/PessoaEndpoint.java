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

import com.stefanini.exception.PessoaInexistenteException;
import com.stefanini.model.Pessoa;
import com.stefanini.service.PessoaService;

@Path("/pessoas")
public class PessoaEndpoint {
	@Inject
	PessoaService pessoaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> index() {
		return pessoaService.showAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa find(@PathParam("id") int id) throws PessoaInexistenteException {
		return pessoaService.find(id);
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Pessoa pessoa) {
		Pessoa pessoaCadastrada = pessoaService.insert(pessoa);
		return Response.status(201).entity(pessoaCadastrada).build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Pessoa pessoa) throws PessoaInexistenteException {
		pessoaService.update(pessoa);
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) throws PessoaInexistenteException {
		pessoaService.delete(id);
		return Response.status(200).build();
	}
	
	
}
