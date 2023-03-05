package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ParseBodyFromAnotherClass {
	
	
	
	@Test
	public void createUser()
	{
RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		.header("Content-Type", "application/json")
		.body(JsonBody.createUserBody())
		.log().all()
		.when()
		
		.post("/user")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}

}
