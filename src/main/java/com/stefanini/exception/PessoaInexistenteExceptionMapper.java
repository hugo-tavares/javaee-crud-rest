package com.stefanini.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PessoaInexistenteExceptionMapper implements ExceptionMapper<PessoaInexistenteException> {

    @Override
    public Response toResponse(PessoaInexistenteException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .header("Conflict-Reason", exception.getMessage())
                .build();
    }

}