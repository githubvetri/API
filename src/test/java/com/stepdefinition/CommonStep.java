package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.common.CommonVariables;

import cucumber.api.java.en.Then;

public class CommonStep extends BaseClass {

	@Then("User verify the status code is {int}")
	public void user_verify_the_status_code_is(int int1) {

		CommonVariables commonVariables = new CommonVariables();
		int statusCode = getStatusCode(LoginStep.commonVariables.getResponse());
		String string = String.valueOf(statusCode);
		System.out.println(statusCode);
		Assert.assertEquals("Verify StatusCode", int1, statusCode);

	}

}
