package com.common;

import io.restassured.response.Response;

public class CommonVariables {

	private String logtoken;
	private Response response;
	
	
	public String getLogtoken() {
		return logtoken;
	}
	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
