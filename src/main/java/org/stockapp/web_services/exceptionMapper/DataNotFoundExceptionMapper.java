package org.stockapp.web_services.exceptionMapper;

import org.stockapp.web_services.exception.DataNotFoundException;
import org.stockapp.web_services.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage er = new ErrorMessage(404, exception.getMessage());
		return Response.status(Status.NOT_FOUND)
				       .entity(er)
				       .build();
	}
}
