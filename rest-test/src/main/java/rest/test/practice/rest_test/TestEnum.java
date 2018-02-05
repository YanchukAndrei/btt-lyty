package rest.test.practice.rest_test;

public enum TestEnum {
	
	TEST_ENUM("CODE","VALE");
	
	private String code;
	private String value;
	
	TestEnum(String code, String value){
		this.code=code;
		this.value=value;
	}
	
	public String getCode()
	{
		return this.code;
	}
	
	public String getValueM()
	{
		return this.value;
	}
}
