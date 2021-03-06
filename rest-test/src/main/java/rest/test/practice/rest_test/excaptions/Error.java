package rest.test.practice.rest_test.excaptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Error {
	
	private String message;
	private int code;
	private String documentation;
	
	public Error() {}
	
	public Error(String message, int code, String documentations)
	{
		this.message = message;
		this.code = code;
		this.documentation = documentations;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
