package basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class POST_CreateUser {
	
	static String message = "";
	
	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"testoneuser\",\r\n"
				+ "  \"firstName\": \"morningone\",\r\n"
				+ "  \"lastName\": \"batchone\",\r\n"
				+ "  \"email\": \"morningone.batch@gmail.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9988776658\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		.log().all()
		.when()
		
		.post("/user")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		JsonPath jp = response.jsonPath();
		
 message	=	jp.getString("message");


		
		
		
		
		
	}
	
	
	
	@Test
	public void getUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
Response getresponse	=	given()
		.when()
		
		.get("/user/testoneuser")
		
		.then()
		
		.extract()
		
		.response();

JsonPath jp = getresponse.jsonPath();

String idvalue = jp.getString("id");

Assert.assertEquals(idvalue, message);
		
	}
	
	

}
