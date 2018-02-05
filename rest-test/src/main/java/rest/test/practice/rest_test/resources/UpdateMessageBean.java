package rest.test.practice.rest_test.resources;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;

public class UpdateMessageBean {
	
	private @HeaderParam("userId") String userId; 
	private @PathParam("messageid") Long messageId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	
	
}
