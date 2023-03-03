package basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.time.Duration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
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

	
//	first way to get the value from response:

			JsonPath js = response.jsonPath();
			
			String emailfromresponse = js.getString("data.email");
			
			
			System.out.println("email value is "+emailfromresponse);

			String firstname = js.getString("data.first_name");
			
			System.out.println(firstname);
			
			int idvalue = js.getInt("data.id");

			System.out.println(idvalue);



// second way to get the response
			
	String stringresponse = response.asPrettyString();
	
	JsonPath jp = new JsonPath(stringresponse);
	
	String url = jp.getString("support.url");
	
	System.out.println(url);
		

	long timetakenforresponse = response.getTime();// this provide the response time for api response
	
	System.out.println(timetakenforresponse);
	
	response.getStatusCode();// this provide the status code for api response
	
	response.getStatusLine();// this provide the status line for api response
	
	

	Assert.assertEquals(emailfromresponse, "janet.weaver@reqres.in");
	}
	
	
	

}
