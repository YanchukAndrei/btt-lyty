package rest.test.practice.rest_test.excaptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

//@Provider
//@Produces(MediaType.APPLICATION_JSON)
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		Error error = new Error("Server Error", 500, "/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}

}
