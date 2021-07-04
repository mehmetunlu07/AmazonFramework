package com.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
//1. Use any 2 methods(Get, and Delete) from end-points listed in http://dummy.restapiexample.com/
//2. Perform assertions for 
//   - Get & Delete - Status code to be Successful.
//   - Get - Return specific Employee details(Any).
//   - Delete - "message": "successfully! deleted Records".

public class TestAPI {

	public static void main(String[] args) {
		RestAssured.baseURI="http://dummy.restapiexample.com/api";
		
		//GET call
		Response response=given().when().get("/v1/employee/1");
		response.prettyPrint();
		response.then().statusCode(200);
		String name="Tiger Nixon";
		response.then().body("data.employee_name", equalTo(name));
		String empId=response.body().jsonPath().getString("data.id");
		System.out.println("Employee id: "+ empId);
		
		//DELETE call
		Response deleteResponse=given().queryParam("data.id", empId).when().delete("/v1/delete/2");
		deleteResponse.prettyPrint();
		int code=deleteResponse.getStatusCode();
		System.out.println(code);
		deleteResponse.then().statusCode(code);
		JsonPath js=new JsonPath(deleteResponse.asString());
		String text=js.getString("message");
		System.out.println(text);

	}

}
