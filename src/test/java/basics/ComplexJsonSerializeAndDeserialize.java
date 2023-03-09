package basics;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Data;
import pojo.ResourcesResBody;

public class ComplexJsonSerializeAndDeserialize {
	
	
	@Test
	public void getEmail()
	{
		RestAssured.baseURI = "https://reqres.in";
	
	ResourcesResBody resourceresbody = given()
		
		.log().all()
		
		.when()
		
		.get("api/users?page=2")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response().as(ResourcesResBody.class);
	
	
	int page = resourceresbody.getPage();
		
	
	System.out.println(page);

		

	
	
	}

}
