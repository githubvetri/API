package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.Login_output_pojo;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.ChangeProfilePic_Output_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class OMRBranchClub extends BaseClass {

	String logtoken;
	int address_id;

	@Test(priority = 1)
	public void login() throws FileNotFoundException, IOException {

		// 1.Header
		addHeader("Content-Type", "application/json");

		basicAuth(getPropertyValue("username"), getPropertyValue("password"));

		Response response = requestType("POST", EndPoints.LOGIN);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		Assert.assertEquals(200, statusCode, "Verify StatusCode");

		// 4.Login Class

		Login_output_pojo login_output_pojo = response.as(Login_output_pojo.class);

		// 5.Get Data

		String message = login_output_pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals("Login successfully", message, "Verify Message");

		logtoken = login_output_pojo.getData().getLogtoken();
	}

	@Test(priority = 2)
	public void createAddress() {

		// 1.Header
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

		// 2.Add Datas

		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo("Vetri", "Hani", "8220260322", "Siva",
				33, 3378, 101, "636303", "Mettur", "home");
		addBody(addAddress_Input_pojo);

		// 3.Method Type

		Response response = requestType("POST", EndPoints.ADDADDRESS);

		int statusCode = getStatusCode(response);

		Assert.assertEquals(statusCode, 200, "Verify status code");

		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);

		String message = addAddress_Output_pojo.getMessage();
		System.out.println(message);

		address_id = addAddress_Output_pojo.getAddress_id();

		Assert.assertEquals(message, "Address added successfully", "Verify address");

	}

	@Test(priority = 3)

	public void updateAddress() {

		// 1.Header
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(String.valueOf(address_id),
				"Vetri", "Sakthi", "8220260322", "Met", 54, 34, 103, "600097", "OMR", "home");

		addBody(updateAddress_Input_Pojo);

		// req Type

		Response response = requestType("PUT", EndPoints.UPDATEADDRESS);

		int statusCode = getStatusCode(response);

		Assert.assertEquals(statusCode, 200, "Verify status Code");

		UpdateAddress_Output_Pojo updateAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);

		String message = updateAddress_Output_Pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals(message, "Address updated successfully", "Verify address updated");

	}

	@Test(priority = 4)

	public void getAddresses() {

		// 1.Header
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);
		Response response = requestType("GET", EndPoints.GETADDRESSES);

		int statusCode = getStatusCode(response);

		Assert.assertEquals(statusCode, 200, "Verify Status code");

		GetAddress_Output_Pojo getAddress_Output_Pojo = response.as(GetAddress_Output_Pojo.class);

		String message = getAddress_Output_Pojo.getMessage();

		Assert.assertEquals(message, "OK", "Verify ok");

	}

	@Test(priority = 5)

	public void deleteAddress() {

		// 1.Header
		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(String.valueOf(address_id));

		addBody(deleteAddress_Input_Pojo);

		Response response = requestType("DELETE", EndPoints.DELETEADDRESS);

		int statusCode = getStatusCode(response);

		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);

		String message = deleteAddress_Output_Pojo.getMessage();

		Assert.assertEquals(message, "Address deleted successfully", "Verify address deleted");

	}

	@Test(priority = 6)
	public void profilepicUpdate() {

		List<Header> h = new ArrayList<Header>();

		Header h1 = new Header("Content-Type", "multipart/form-data");

		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		h.add(h1);
		h.add(h2);

		Headers headers = new Headers(h);

		addHeaders(headers);

		formData();

		Response response = requestType("POST", EndPoints.UPDATEPROFILEPIC);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		ChangeProfilePic_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfilePic_Output_Pojo.class);

		String message = changeProfilePic_Output_Pojo.getMessage();

		Assert.assertEquals(message, "Profile updated Successfully", "Verify Profile updated Successfully");

	}

}
