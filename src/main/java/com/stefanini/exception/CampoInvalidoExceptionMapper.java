package com.stefanini.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CampoInvalidoExceptionMapper implements ExceptionMapper<ExistenteException> {

	@Override
	public Response toResponse(ExistenteException exception) {
		return Response.status(Response.Status.BAD_REQUEST).header("Motivo: ", exception.getMessage()).build();
	}
}