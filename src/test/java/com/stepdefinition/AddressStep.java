package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.common.CommonVariables;
import com.endpoints.EndPoints;
import com.payloads.Payload;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AddressStep extends BaseClass {

	public static CommonVariables commonVariables;
	Payload payload;
	static int addressid;

	@Given("User should add headers")
	public void user_should_add_headers() {

		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogtoken());

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

	}

	@Given("User should add  {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}and{string}")
	public void user_should_add_and(String first_name, String last_name, String mobile, String apartment, String state,
			String city, String country, String zipcode, String address, String address_type) {

		payload = new Payload();
		AddAddress_Input_pojo create = payload.createAddress(first_name, last_name, mobile, apartment, state, city,
				country, zipcode, address, address_type);
		addBody(create);

	}

	@When("User should send {string} request for address endpoint")
	public void user_should_send_request_for_address_endpoint(String string) {
		Response response = requestType("POST", EndPoints.ADDADDRESS);
		LoginStep.commonVariables.setResponse(response);
	}

	@Then("User should verify the response body message present as {string} and get the address Id saved")
	public void user_should_verify_the_response_body_message_present_as_and_get_the_address_Id_saved(String string) {

		AddAddress_Output_pojo addAddress_Output_pojo = LoginStep.commonVariables.getResponse()
				.as(AddAddress_Output_pojo.class);

		String message = addAddress_Output_pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals("Verify Message", "Address added successfully", message);
		addressid = addAddress_Output_pojo.getAddress_id();
		System.out.println(addressid);

	}

	@Given("User should add header")
	public void user_should_add_header() {

		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogtoken());

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

	}

	@Given("User should add required data for updating the address {string}, {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}and {string}")
	public void userShouldAddRequiredDataForUpdatingTheAddressAnd(String address_id, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		UpdateAddress_Input_Pojo update = payload.updateAddress(String.valueOf(addressid),first_name, last_name, mobile, apartment, state, city,
				country, zipcode, address, address_type);

		addBody(update);

	}

	@When("User should send {string} request for AddAddress endpoint")
	public void user_should_send_request_for_AddAddress_endpoint(String string) {
		Response response = requestType("PUT", EndPoints.UPDATEADDRESS);
		LoginStep.commonVariables.setResponse(response);

	}

	@Then("User should verify the response body update address message present as {string}")
	public void user_should_verify_the_response_body_update_address_message_present_as(String string) {
		UpdateAddress_Output_Pojo updateAddress_Output_Pojo = LoginStep.commonVariables.getResponse()
				.as(UpdateAddress_Output_Pojo.class);

		String message = updateAddress_Output_Pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals("Verify Address Updated", "Address updated successfully", message);
	}

	@Given("User should enter addressId to get the addresses")
	public void user_should_enter_addressId_to_get_the_addresses() {
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogtoken());

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

	}

	@When("User should send {string} request for UpdateAddress endpoint")
	public void user_should_send_request_for_UpdateAddress_endpoint(String string) {

		Response response = requestType("GET", EndPoints.GETADDRESSES);
		LoginStep.commonVariables.setResponse(response);

	}

	@Then("User should verify the response body Addaddress message present as {string}")
	public void user_should_verify_the_response_body_Addaddress_message_present_as(String string) {

		GetAddress_Output_Pojo getAddress_Output_Pojo = LoginStep.commonVariables.getResponse()
				.as(GetAddress_Output_Pojo.class);

		String message = getAddress_Output_Pojo.getMessage();

		Assert.assertEquals("Verify ok", "OK", message);
	}

	@Given("User should enter {string} for deleting the address")
	public void userShouldEnterForDeletingTheAddress(String string) {

		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogtoken());

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

	}

	@When("User should send {string} request for login endpoint")
	public void user_should_send_request_for_login_endpoint(String address_id) {

		DeleteAddress_Input_Pojo delete = payload.deleteAddress(String.valueOf(addressid));

		addBody(delete);

		Response response = requestType("DELETE", EndPoints.DELETEADDRESS);
		LoginStep.commonVariables.setResponse(response);

	}

	@Then("User should verify the response body delete address message present as {string}")
	public void user_should_verify_the_response_body_delete_address_message_present_as(String string) {
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = LoginStep.commonVariables.getResponse()
				.as(DeleteAddress_Output_Pojo.class);

		String message = deleteAddress_Output_Pojo.getMessage();

		Assert.assertEquals("Verify DeleteAddress Succuessfully", "Address deleted successfully", message);
	}

}
