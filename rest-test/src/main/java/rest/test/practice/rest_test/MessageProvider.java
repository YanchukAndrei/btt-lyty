package rest.test.practice.rest_test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import rest.test.practice.rest_test.resources.Message;
import rest.test.practice.rest_test.resources.UpdateMessageBean;

@Path("/messages")
/**
 * During sub-resource inharitance @Path not needed.
 **/
public class MessageProvider {

	private MessageService service = new MessageService();
	private ProfileService profileService = new ProfileService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> messages(@PathParam("profileName") String profileName, @QueryParam("year") Integer year) {
		System.out.println(year);

		if(profileName != null)
		{
			return profileService.getProfileMessages(profileName);
		}
		
		if (year != null)
			return service.getMessagesForYear(year.intValue());

		return service.getMessages();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public Message message(@PathParam("messageid") Long messageId, @Context UriInfo uriInfo) {
		
		Message message = service.getMessage(messageId);
		if(message != null)
		{
			String uri = uriInfo.getBaseUriBuilder().path(MessageProvider.class).path(message.getMessageId().toString()).build().toString();
			message.addLink(uri, "self");
			
			String uriProfile = uriInfo.getBaseUriBuilder().path(ProfileProvider.class).build().toString();
			message.addLink(uriProfile, "profile");
			
			String uriProfileMessages = uriInfo.getBaseUriBuilder().path(ProfileProvider.class, "getProfileMessages").resolveTemplate("profileName","ProfileNamePlace").build().toString();
			message.addLink(uriProfileMessages, "profileMessages");
			}
		return message;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(@Context UriInfo uriInfo, @HeaderParam("userId") String userId, Message message) throws URISyntaxException {
		
		if(message.getMessage()==null)
			return Response.status(Status.NO_CONTENT).build();
		
		message.setUserId(userId);
		service.addMessage(message);
		return Response.status(Status.CREATED) // Request status
				.location(uriInfo.getAbsolutePathBuilder().path(message.getMessageId().toString()).build()) //Header location value - for created element
				.entity(message) //Response body
				.build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public List<Message> updateMessage(@BeanParam UpdateMessageBean beanParam, Message message) {
		message.setUserId(beanParam.getUserId());
		service.updateMessage(beanParam.getMessageId(), message);
		return service.getMessages();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public List<Message> deleteMessage(@PathParam("messageid") Long messageId) {
		service.removeMessage(messageId);
		return service.getMessages();
	}
}
