package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetValueFromResponse {
	
	
	
	@Test
	public void getEmail()
	{
		RestAssured.baseURI = "https://reqres.in";
	
Response response	=	given()
		
		.log().all()
		
		.when()
		
		.get("api/users?page=2")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		

JsonPath jp = response.jsonPath();

String emailfor10id = jp.getString("data[3].email");

System.out.println(emailfor10id);

	int page = jp.getInt("page");
	
	System.out.println(page);//2
		
	int per_page = jp.getInt("per_page");
	
	System.out.println(per_page);//6
	
	int statuscode = response.getStatusCode();
	System.out.println(statuscode);
	
	String statusline = response.getStatusLine();
	
	System.out.println(statusline);
	
	
	}
	

}
