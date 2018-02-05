package rest.test.practice.rest_test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rest.test.practice.rest_test.resources.Message;
import rest.test.practice.rest_test.resources.ProfileType;

public class ProfileService {
	
	private static Map<String, ProfileType> profiles = new HashMap<>();
	private MessageService messageService = new MessageService();


	static{
		ProfileType profile1 = new ProfileType();
		profile1.setId(1L);
		profile1.setName("Proflie1");
		profile1.setDescription("Description 1");
		
		ProfileType profile2 = new ProfileType();
		profile2.setId(1L);
		profile2.setName("Proflie2");
		profile2.setDescription("Description 2");
		
		Message message1 = new Message();
		message1.setMessage("Profile Message 1");
		message1.setMessageId(1L);
		profile1.addMessage(message1);

		Message message2 = new Message();
		message2.setMessage("Profile Message 2");
		message2.setMessageId(2L);
		profile2.addMessage(message2);
		
		profiles.put("Proflie1", profile1);
		profiles.put("Proflie2", profile2);
	}
	
	public Collection<ProfileType> getProfiles()
	{
		return profiles.values();
	}
	
	public ProfileType getProfile(String name)
	{
		return profiles.get(name);
	}
	
	public ProfileType addProfile(ProfileType profile)
	{
		if(profile.getName() == null)
			return null;
		
		profiles.put(profile.getName(), profile);
		return profile;
	}
	
	public ProfileType updateProfile(String name, ProfileType profileType)
	{
		profiles.replace(name, profileType);
		return profileType;
	}
	
	public List<Message> getProfileMessages(String profileName)
	{
		return profiles.get(profileName).getMessages();
	}
}
