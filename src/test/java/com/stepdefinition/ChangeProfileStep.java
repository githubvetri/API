package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.ChangeProfilePic_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ChangeProfileStep extends BaseClass {

	@Given("User should add the headers")
	public void userShouldAddTheHeaders() {

		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "multipart/form-data");

		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogtoken());

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

		formData();

	}

	@When("User should send {string} request for Updateprofilepic endpoint")
	public void userShouldSendRequestForUpdateprofilepicEndpoint(String string) {
		Response response = requestType("POST", EndPoints.UPDATEPROFILEPIC);
		LoginStep.commonVariables.setResponse(response);
	}

	@Then("User should verify the response body of update profilepic message present as {string}")
	public void userShouldVerifyTheResponseBodyOfUpdateProfilepicMessagePresentAs(String string) {

		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = LoginStep.commonVariables.getResponse()
				.as(ChangeProfilePic_Output_Pojo.class);

		String message = changeProfilePic_Output_Pojo.getMessage();

		Assert.assertEquals(message, "Profile updated Successfully", "Verify Profile updated Successfully");

	}

}
