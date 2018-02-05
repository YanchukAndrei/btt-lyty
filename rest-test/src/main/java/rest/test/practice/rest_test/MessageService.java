package rest.test.practice.rest_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import rest.test.practice.rest_test.excaptions.MessageNotFound;
import rest.test.practice.rest_test.resources.Message;

import rest.test.practice.rest_test.excaptions.Error;

public class MessageService {
	
	public static List<Message> messages = new ArrayList<>();
	
	static {
		Message message1 = new Message();
		message1.setMessage("Message 1");
		message1.setMessageId(1L);
		message1.setYear(2016);

		Message message2 = new Message();
		message2.setMessage("Message 2");
		message2.setMessageId(2L);
		message2.setYear(2017);

		messages.add(message1);
		messages.add(message2);
	}

	public List<Message> getMessages() {
		return messages;
	}
	
	public List<Message> getMessagesForYear(int year) {
		List<Message> result = new ArrayList<>();
		for(Message message: messages)
		{
			if(message.getYear() == year)
			{
				result.add(message);
			}
		}
		return result;
	}
	
	public Message getMessage(Long id)
	{
		if(id > 1000L)
		{
			Error webError = new Error("message", Status.FORBIDDEN.getStatusCode(), "/");
			throw new WebApplicationException(Response.status(Status.FORBIDDEN).entity(webError).build());
		}
		
		for(Message message: messages)
		{
			if(message.getMessageId().equals(id))
			{
				return message;
			}
		}
		
		throw new MessageNotFound();
	}
	
	public void addMessage(Message newMessage)
	{
		newMessage.setMessageId(Long.valueOf(Integer.toString(messages.size()+1)));
		messages.add(newMessage);
	}
	
	public void updateMessage(Long messaageId, Message updatedMessage)
	{
		for(Message message: messages)
		{
			if(message.getMessageId().equals(messaageId))
			{
				message.setMessage(updatedMessage.getMessage());
				message.setUserId(updatedMessage.getUserId());
			}
		}
	}
	
	public void removeMessage(Long messageId)
	{
	   Iterator<Message> iterator =  messages.iterator();
	   while(iterator.hasNext())
	   {
		   Message message = iterator.next();
			if(message.getMessageId().equals(messageId))
			{
				iterator.remove();
			}
	   }
	}
}
