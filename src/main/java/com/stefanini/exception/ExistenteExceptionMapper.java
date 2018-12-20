package com.stefanini.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExistenteExceptionMapper implements ExceptionMapper<ExistenteException> {

    @Override
    public Response toResponse(ExistenteException exception) {
        return Response.status(Response.Status.CONFLICT)
                .header("Motivo: ", exception.getMessage())
                .build();
    }

}