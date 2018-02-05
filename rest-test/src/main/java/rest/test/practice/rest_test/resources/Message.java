package rest.test.practice.rest_test.resources;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * JaxB annotations
 */

@XmlRootElement // for jaxb automatic conversion
public class Message {

	private Long messageId;
	private String message;
	private String userId;
	private int year;
	private List<Link> links = new ArrayList<>();

	public Message() {
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLink(String url, String ref) {
		links.add(new Link(url, ref));
	}
}
