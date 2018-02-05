package rest.test.practice.rest_test.excaptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider // this package will be scanned during container start.
public class MessageNotFoundExceptionMapper implements ExceptionMapper<MessageNotFound>{

	@Override
	public Response toResponse(MessageNotFound exception) {
		
		Error error = new Error("Message Not Found", 400, "/dock/link");
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
