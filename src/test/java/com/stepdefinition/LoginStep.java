package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.common.CommonVariables;
import com.endpoints.EndPoints;
import com.pojo.Login_output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class LoginStep extends BaseClass {

	public static CommonVariables commonVariables;

	@Given("User add headers")
	public void user_add_headers() throws FileNotFoundException, IOException {

		addHeader("Content-Type", "application/json");
		basicAuth(getPropertyValue("username"), getPropertyValue("password"));
	}

	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String string) {

		Response response = requestType("POST", EndPoints.LOGIN);
		commonVariables = new CommonVariables();
		LoginStep.commonVariables.setResponse(response);
	}

	@Then("User verify the response body firstname present as {string} and the logtoken saved")
	public void user_verify_the_response_body_firstname_present_as_and_the_logtoken_saved(String string) {

		Login_output_pojo login_output_pojo = commonVariables.getResponse().as(Login_output_pojo.class);

		String email = login_output_pojo.getData().getEmail();
		Assert.assertEquals("Verify Email", "venkatachalam2233@gmail.com", email);

		String first_name = login_output_pojo.getData().getFirst_name();
		Assert.assertEquals("Verify Firstname", "VENKATACHALAM R", first_name);

		String logtoken = login_output_pojo.getData().getLogtoken();
		commonVariables.setLogtoken(logtoken);
		System.out.println(logtoken);
	}

}
