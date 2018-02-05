package rest.test.practice.rest_test.resources;

public class Link {
	private String url;
	private String ref;
	
	public Link() {}
	
	public Link (String url, String ref)
	{
		this.url = url;
		this.ref = ref;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
