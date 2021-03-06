package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqspec;
	Response response;

	public String getPropertyValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(
				new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	public void addHeader(String key, String value) {
		reqspec = RestAssured.given().header(key, value);

	}

	public void addHeaders(Headers header) {
		reqspec = RestAssured.given().headers(header);
	}

	public void queryParam(String key, String value) {
		reqspec = reqspec.queryParam(key, value);

	}

	public void pathParam(String key, String value) {
		reqspec = reqspec.pathParam(key, value);
	}

	public void basicAuth(String userName, String password) {
		reqspec = reqspec.auth().preemptive().basic(userName, password);
	}

	public void formData() {
		reqspec = reqspec.multiPart("profile_picture", new File("E:\\VETRI\\baby.jpg"));
	}

	public void addBody(String body) {
		reqspec = reqspec.body(body);
	}

	public void addBody(Object body) {
		reqspec = reqspec.body(body);

	}

	public Response requestType(String reqType, String endPoint) {

		switch (reqType) {
		case "GET":
			response = reqspec.log().all().get(endPoint);
			break;

		case "POST":
			response = reqspec.log().all().post(endPoint);
			break;

		case "PUT":
			response = reqspec.log().all().put(endPoint);
			break;

		case "DELETE":
			response = reqspec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
		return response;

	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public ResponseBody getBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}

	public String getBodyAsString(Response response) {
		String asString = getBody(response).asString();
		return asString;
	}

	public String getBodyAsPrettyString(Response response) {
		String jsonFormat = getBody(response).asPrettyString();
		return jsonFormat;
	}
}
