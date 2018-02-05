package rest.test.practice.rest_test;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.test.practice.rest_test.resources.ProfileType;

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileProvider {

	private ProfileService service = new ProfileService();
	
	@GET
	public Collection<ProfileType> getAllProfiles()
	{
		return service.getProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public ProfileType getProfile(@PathParam("profileName") String name)
	{
		return service.getProfile(name);
	}
	
	@POST
	public ProfileType addProfile(ProfileType profile)
	{
		return service.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public ProfileType updateProfile(@PathParam("profileName") String name, ProfileType profile)
	{
		return service.updateProfile(name, profile);
	}
	
	//resourse enharitance
	@Path("/{profileName}/messages")
	public MessageProvider getProfileMessages()
	{
		return new MessageProvider();
	}
}
