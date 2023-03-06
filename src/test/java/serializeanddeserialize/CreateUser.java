package serializeanddeserialize;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.RequestBody;
import pojo.ResponseBody;

public class CreateUser {
	
	
	
	@Test
	public void createUser()
	{
		RequestBody requestbody  = new RequestBody();
		
		requestbody.setId(0);
		requestbody.setUsername("userone");
		requestbody.setFirstName("Ron");
		requestbody.setLastName("Dutta");
		requestbody.setEmail("ron.dutta@gmail.com");
		requestbody.setPassword("Test@12345");
		requestbody.setPhone("9874562130");
		requestbody.setUserStatus(0);
		
			
RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
ResponseBody responsebody	= given()
							.header("Content-Type", "application/json")
							.body(requestbody)
							.log().all()
							.when()
		
							.post("/user")
		
							.then()
		
							.log().all()
		
							.extract()
		
							.response()
							.as(ResponseBody.class);

	String message = responsebody.getMessage();
	
	System.out.println(message);
		
	}

}
