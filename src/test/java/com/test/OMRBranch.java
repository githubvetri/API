package com.test;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pojo.Login_output_pojo;

import io.restassured.response.Response;

public class OMRBranch extends BaseClass {

	@Test
	public void login() {

		// 1.Header
		addHeader("Content-Type", "application/json");

		// 2.Basic Auth

		basicAuth("venkatachalam2233@gmail.com", "Vetri@1999");

		// 3.Req Type
		Response response = requestType("POST", "https://omrbranch.com/api/login");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		// 4.Login Class

		Login_output_pojo login_output_pojo = response.as(Login_output_pojo.class);
		
		//5.Get Data
		
		String message = login_output_pojo.getMessage();
		System.out.println(message);
		
		String logtoken = login_output_pojo.getData().getLogtoken();
		System.out.println(logtoken);
		
		
		

	}

}
