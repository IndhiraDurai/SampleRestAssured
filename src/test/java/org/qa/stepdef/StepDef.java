package org.qa.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef {

	RequestSpecification req;
	Response res;
	@Given("Hitting the API")
	public void hitting_the_api() {
	    RestAssured.baseURI="https://reqres.in/api/users/2";
	    req = RestAssured.given();
	}

	@Given("Get the response from API")
	public void get_the_response_from_api() {
	  res=req.get();
	}

	@When("print the response")
	public void print_the_response() {
	    res.prettyPrint();
	}

	@Then("print the specific value from response")
	public void print_the_specific_value_from_response() {
	    System.out.println(res.jsonPath().getString("x.data.first_name"));
	}

	@Then("print the status code from response")
	public void print_the_status_code_from_response() {
	    System.out.println(res.getStatusCode());
	}

	@Then("print the status msg from response")
	public void print_the_status_msg_from_response() {
		
		System.out.println(res.getStatusLine());
	}
	
	@Given("Hitting the API for post method")
	public void hitting_the_api_for_post_method() {
		 RestAssured.baseURI="https://reqres.in/api/users";
		    req = RestAssured.given().body("{\r\n"
		    		+ "    \"name\": \"morpheus\",\r\n"
		    		+ "    \"job\": \"leader\"\r\n"
		    		+ "}");
	}

	@Given("Get the response from API for post method")
	public void get_the_response_from_api_for_post_method() {
	   res = req.post();
	}
	@Then("print the specific value from response for post method")
	public void print_the_specific_value_from_response_for_post_method() {
		 System.out.println(res.jsonPath().getString("x.createdAt"));
	}
}
