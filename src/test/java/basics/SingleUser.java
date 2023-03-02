package basics;

import org.testng.annotations.Test;

import groovy.time.Duration;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public  class SingleUser {
	
	
	@Test(priority = 1)
	public void getSingleUser()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		given()
		
		.when()
		
		.get("/api/users/2")
		
		.then()
		
		.assertThat()
		
		.statusCode(200);
		
				
	}
	
	
	@Test(priority = 2)
	public void validateEmailFromResponse()
	{
		RestAssured.baseURI = "https://reqres.in";
		
Response response = given()
		.log().all()
		
		.when()
		
		.get("/api/users/2")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();

	
		


				
	}
	
	
	

}
